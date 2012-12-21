/*
 Mode :
 0 - readonly
 1 - edit with just a link
 2 - edit with add/cancel feature
 3 - delete grid view
 4 - enabled all grid feature
 5 - create a blank grid to insertion of new record purposes.
 6 - create editable grid
 */

var globalCurrentId;

var CoreGrid = function () {
    var editUrl;
    var controlIdName = "grid";

    this.createGridFilter = function (gridDataObjects) {
        if (gridDataObjects.columns == undefined)
            return;

        if (gridDataObjects.model == undefined)
            return;

        if (gridDataObjects.listBoxDataObject != undefined) {
            switch (gridDataObjects.listBoxDataObject.controlType) {
                case 0:
                    // create combo box
                    createListControl(gridDataObjects.listBoxDataObject.url, gridDataObjects.listBoxDataObject);
                    break
                case 1:
                    // create listbox
                    createListControl(gridDataObjects.listBoxDataObject.url, gridDataObjects.listBoxDataObject);
                    break;
                case 2:
                    // create both control
                    createListControl(gridDataObjects.listBoxDataObject.url, gridDataObjects.listBoxDataObject);
                    break;
            }
        }
        createTextFilterControl(gridDataObjects);
        this.createGrid(gridDataObjects);
    }

    function createTextFilterControl(gridDataObjects) {
        if (gridDataObjects.textDataObject != undefined) {
            var coreTextBox = new CoreTextBox();
            coreTextBox.renderControl(gridDataObjects.textDataObject);
        }
    }

    function createListControl(url, controlData) {
        var coreListControl = new CoreListControl();
        coreListControl.renderControl(url, controlData);
    }

    this.createGrid = function (gridDataObjects) {
        if (gridDataObjects.columns == undefined)
            return;

        if (gridDataObjects.model == undefined)
            return;


        if (gridDataObjects.updateLinkInfo != undefined)
            editUrl = gridDataObjects.updateLinkInfo.link;

        var gridUrl = gridDataObjects.gridUrl;
        var data = gridDataObjects.data;
        var model = gridDataObjects.model;
        var columns = gridDataObjects.columns;
        var controlId = gridDataObjects.controlId;
        var mode = gridDataObjects.mode;

        if (controlId != undefined)
            controlIdName = controlId;

        switch (mode) {
            case 0:
                createReadOnlyGrid(gridDataObjects);
                break;
            case 1:
                createEditEnabledOnlyGrid(gridUrl, data, model, columns);
                break;
            case 2:
                createEditModeOnlyGrid(gridUrl, data, model, columns);
                break;
            case 3:
                createDeleteOnlyGrid(gridUrl, data, model, columns);
                break;
            case 4:
                createAllFeatureGrid(gridDataObjects);
                break;
            case 5:
                createInsertCommandGrid(gridDataObjects);
                break;
            case 6:
                createEditCommandGrid(gridDataObjects);
                break;
            default:
                createReadOnlyGrid(gridDataObjects);
                break;
        }
    }


    function createAllFeatureGrid(gridDataObjects) {
        var gridUrl = gridDataObjects.gridUrl;
        var data = gridDataObjects.data;
        var model = gridDataObjects.model;
        var columns = gridDataObjects.columns;
        var gridUpdateTitle = gridDataObjects.updateLinkInfo.text;

        var deleteObject = { command:"destroy", title:"", width:50 };
        columns.columns.push(deleteObject);

        var editObject = { command:{ text:"Edit", click:showDetails }, title:gridUpdateTitle, width:50 };
        columns.columns.push(editObject);

        $("#" + controlIdName).kendoGrid({
            dataSource:{

                transport:{
                    read:{
                        dataType:"json",
                        url:gridUrl + "/list"
                    },
                    update:{
                        url:gridUrl + "/saveOrUpdate",
                        dataType:"json"
                    },
                    destroy:{
                        url:gridUrl + "/delete",
                        dataType:"json"
                    },
                    createMessageBox:{
                        url:gridUrl + "/add",
                        dataType:"json"
                    }
                },
                data:data,
                pageSize:10,
                schema:{
                    model:model
                }
            },
            editable:true,
            resizable:true,
            reorderable:true,
            groupable:false,
            selectable:true,
            sortable:true,
            pageable:true,
            columns:columns.columns,
            remove:function (e) {
                $.ajax({
                    url:gridUrl + "/delete",
                    data:{"id":e.model.nid},
                    type:"get",
                    dataType:"json"
                });
            }
        });
    }

    function createDeleteOnlyGrid(gridUrl, data, model, columns) {
        var editObject = { command:"destroy", title:"", width:50 };
        columns.columns.push(editObject);

        $("#" + controlIdName).kendoGrid({
            dataSource:{

                transport:{
                    read:{
                        dataType:"json",
                        url:gridUrl + "/list"
                    },
                    update:{
                        url:gridUrl + "/saveOrUpdate",
                        dataType:"json"
                    },
                    destroy:{
                        url:gridUrl + "/delete",
                        dataType:"json"
                    },
                    createMessageBox:{
                        url:gridUrl + "/add",
                        dataType:"json"
                    }
                },
                data:data,
                pageSize:10,
                schema:{
                    model:model
                }
            },

            editable:true,
            resizable:true,
            reorderable:true,
            groupable:false,
            selectable:true,
            sortable:true,
            pageable:true,
            columns:columns.columns,
            remove:function (e) {
                $.ajax({
                    url:gridUrl + "/delete",
                    data:{"id":e.model.nid},
                    type:"get",
                    dataType:"json"
                });
            }
        });
    }

    function createEditModeOnlyGrid(gridUrl, data, model, columns) {
        var editObject = { command:"destroy", title:"", width:50 };
        columns.columns.push(editObject);

        $("#" + controlIdName).kendoGrid({
            dataSource:{

                transport:{
                    read:{
                        dataType:"json",
                        url:gridUrl + "/list"
                    },
                    update:{
                        url:gridUrl + "/saveOrUpdate",
                        dataType:"json"
                    },
                    destroy:{
                        url:gridUrl + "/delete",
                        dataType:"json"
                    },
                    createMessageBox:{
                        url:gridUrl + "/add",
                        dataType:"json"
                    }
                },
                data:data,
                pageSize:10,
                schema:{
                    model:model
                }
            },
            toolbar:["create", "cancel"],
            editable:true,
            resizable:true,
            reorderable:true,
            groupable:false,
            selectable:true,
            sortable:true,
            pageable:true,
            columns:columns.columns,
            remove:function (e) {
                $.ajax({
                    url:gridUrl + "/delete",
                    data:{"id":e.model.nid},
                    type:"get",
                    dataType:"json"
                });
            }
        });
    }

    function createEditEnabledOnlyGrid(gridUrl, data, model, columns) {

        var editObject = { command:{ text:"Edit", click:showDetails }, title:"", width:50 };
        columns.columns.push(editObject);

        $("#" + controlIdName).kendoGrid({
            dataSource:{

                transport:{
                    read:{
                        dataType:"json",
                        url:gridUrl + "/list"
                    },
                    update:{
                        url:gridUrl + "/saveOrUpdate",
                        dataType:"json"
                    },
                    destroy:{
                        url:gridUrl + "/delete",
                        dataType:"json"
                    },
                    createMessageBox:{
                        url:gridUrl + "/add",
                        dataType:"json"
                    }
                },
                data:data,
                pageSize:10,
                schema:{
                    model:model
                }
            },
            editable:true,
            resizable:true,
            reorderable:true,
            groupable:false,
            selectable:true,
            sortable:true,
            pageable:true,
            columns:columns.columns
        });
    }

    function createReadOnlyGrid(gridDataObjects) {
        var gridUrl = gridDataObjects.gridUrl;
        var data = gridDataObjects.data;
        var model = gridDataObjects.model;
        var columns = gridDataObjects.columns;

        $("#" + controlIdName).kendoGrid({
            dataSource:{

                transport:{
                    read:{
                        dataType:"json",
                        url:gridUrl + "/list"
                    },
                    update:{
                        url:gridUrl + "/saveOrUpdate",
                        dataType:"json"
                    },
                    destroy:{
                        url:gridUrl + "/delete",
                        dataType:"json"
                    },
                    createMessageBox:{
                        url:gridUrl + "/add",
                        dataType:"json"
                    }
                },
                data:data,
                pageSize:10,
                schema:{
                    model:model
                }
            },

            editable:true,
            resizable:true,
            reorderable:true,
            groupable:false,
            selectable:true,
            sortable:true,
            pageable:true,
            columns:columns.columns
        });
    }

    function createReadOnlyGrid(gridDataObjects) {
        var gridUrl = gridDataObjects.gridUrl;
        var data = gridDataObjects.data;
        var model = gridDataObjects.model;
        var columns = gridDataObjects.columns;

        $("#" + controlIdName).kendoGrid({
            dataSource:{

                transport:{
                    read:{
                        dataType:"json",
                        url:gridUrl + "/list"
                    },
                    update:{
                        url:gridUrl + "/saveOrUpdate",
                        dataType:"json"
                    },
                    destroy:{
                        url:gridUrl + "/delete",
                        dataType:"json"
                    },
                    createMessageBox:{
                        url:gridUrl + "/add",
                        dataType:"json"
                    }
                },
                data:data,
                pageSize:10,
                schema:{
                    model:model
                }
            },

            editable:true,
            resizable:true,
            reorderable:true,
            groupable:false,
            selectable:true,
            sortable:true,
            pageable:true,
            columns:columns.columns
        });
    }

    function createInsertCommandGrid(gridDataObjects) {
        var editObject = { command:"destroy", title:"", width:50 };
        gridDataObjects.columns.columns.push(editObject);

        $("#" + controlIdName).kendoGrid({
            dataSource:{
                data:gridDataObjects.data,
                pageSize:10,
                schema:{
                    model:gridDataObjects.model
                }
            },
            toolbar:["create", "cancel"],
            editable:true,
            resizable:true,
            reorderable:true,
            groupable:false,
            selectable:true,
            sortable:true,
            pageable:true,
            columns:gridDataObjects.columns.columns,
            remove:function (e) {
                $.ajax({
                    url:gridDataObjects.gridUrl + "/delete",
                    data:{"id":e.model.nid},
                    type:"get",
                    dataType:"json"
                });
            }
        });
    }

    function createEditCommandGrid(gridDataObjects) {
        alert('createeditcommandGrid');

        var gridUrl = gridDataObjects.gridUrl;
        var data = gridDataObjects.data;
        var model = gridDataObjects.model;
        var columns = gridDataObjects.columns;
        var transport = gridDataObjects.transport;

        $("#" + controlIdName).kendoGrid({
            dataSource:{
                transport:transport,
                data:data,
                pageSize:10,
                schema:{
                    model:model
                }
            },
            editable:true,
            toolbar:["create", "cancel"],
            resizable:true,
            reorderable:true,
            groupable:false,
            selectable:true,
            sortable:true,
            pageable:true,
            columns:columns.columns,
            remove:function (e) {
                $.ajax({
                    url:gridUrl + "/delete",
                    data:{"id":e.model.nid},
                    type:"get",
                    dataType:"json"
                });
            }
        });
    }

    function showDetails(e) {
        e.preventDefault();
        var dataItem = this.dataItem($(e.currentTarget).closest("tr"));

        globalCurrentId = dataItem;
        globalFormMode = 2;

        var ajaxCore = new AjaxCore();
        var req = ajaxCore.loadPage(editUrl);
        req.success(function (html) {
            $("#viewPort").html(html);
        });
    }
}