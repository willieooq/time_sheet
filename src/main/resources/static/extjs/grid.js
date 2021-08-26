
Ext.onReady(function () {

    var selection = [];

    var WorkTimeModel = Ext.define('WorkTimeModel', {
        extend: 'Ext.data.Model',
        fields: [
            { name: "'id", mapping: 'id', type: 'string' },
            { name: 'userId', type: 'string' },
            { name: 'date', type: 'date' },
            { name: 'time', type: 'string' },
            { name: 'platform', type: 'string' },
            { name: 'detail', type: 'string' }
        ]
    });
    var workTimes = Ext.create('Ext.data.Store', {
        model: WorkTimeModel,
        autoLoad: {start:1,limit:3},
        pageSize:5,
        proxy: {
            type: 'ajax',
            actionMethods: { read: 'POST' }, //reference to Restful api
            url: 'callRecord', //後端route
            reader: {
                type: 'json',
                root: 'workTimes',
                successProperty: 'success'
                // totalProperty: 'total'
            }
        },
    });
    //建立Grid
    var grid = Ext.create('Ext.grid.Panel', {
        renderTo: 'grid',
        store: workTimes,
        title: 'Log book',
        iconCls: 'icon-grid',
        width: 600,
        bbar: {
            xtype: 'pagingtoolbar',//底部工具列是分頁工具列
            store: workTimes,//按照userStore的資料進行分頁
            displayInfo: true,//顯示共XX頁，每頁顯示XX條的資訊
            items:[{
                xtype:'button',
                text:'del',
                handler:function(){
                    Ext.Array.forEach(selection,function(item,idx){
                        console.log(item.data);
                    });
                }
            }]
        },
        selModel : {
           selType : 'checkboxmodel', // rowmodel is the default selection model
           mode    : 'MULTI',     // Allows selection of multiple rows
           listeners:{
               selectionchange:function( thisObj, selected, eOpts ){
                   selection=selected;
               }
           }
        },
        columns: [
            {
                header: 'User ID',
                dataIndex: 'userId',
                flex: 3,
                sortable: true,
            },
            {
                header: 'Date',
                dataIndex: 'date',
                xtype: 'datecolumn',
                format: 'Y-m-d',
                sortable: true,
                flex: 4
            },
            {
                header: 'Time',
                dataIndex: 'time',
                flex: 4,
                sortable: true
            },
            {
                header: 'Platform',
                dataIndex: 'platform',
                sortable: true,
                flex: 4
            },
            {
                header: 'Detail',
                dataIndex: 'detail',
                sortable: true,
                flex: 6
            }
        ]
    });

});