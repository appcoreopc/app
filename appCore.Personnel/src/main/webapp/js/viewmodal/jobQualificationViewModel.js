var Qualification = function()
{

    this.nid;
    this.level;
    this.fieldOfStudy;
    this.levelDescription;
    this.fieldOfStudyDescription;
}

var JobQualificationViewModel = function(initView, value, data)
{

    this.mode = initView;

    this.centralPage = "jobSetup.jsp";
    this.editPage = "jobSetupEdit.jsp";
    this.addPage = "jobSetupAdd.jsp";
    this.branchForm = "jobSetupForm";
    this.gridUrl = globalHostname + "/app/Job/Qualification";

    this.gridJobQualification = "#qualificationCommand";
    this.gridId = "gridJobQualification";
    this.data = data;

    var model =
    {
        id: "nid",
        fields: {
            nid: { editable: false },
            level : { editable: true, type: "string" },
            fieldOfStudy : { editable: true, validation: { required: true } },
            levelDescription : { editable: true, type: "string" },
            fieldOfStudyDescription : { editable: true, validation: { required: true } }
        }
    };

    var columns = { "columns" : [
        {
            field: "level",
            width: 90,
            title: "Level"
        },
        {
            field: "fieldOfStudy",
            width: 90,
            title: "Study Field"
        },
        {
            field: "levelDescription",
            width: 90,
            title: "Level Description"
        },
        {
            field: "fieldOfStudyDescription",
            width: 90,
            title: "Field Of Study"
        }
    ]};


    this.getView = function()
    {
        var gridDataObject =
        {
            "gridUrl" : this.gridUrl,
            "data" : this.data,
            "columns" : columns,
            "model" : model
        };

        switch (this.mode)
        {
            case 0:

                var addLinkInfo = {
                    "text" : "Save",
                    "commandId" : 'jobQualificationAdd',
                    "link" : this.addPage,
                    "callback" : goToAdd.toString()
                };

                var updateLinkInfo = {
                    "text" : "Update",
                    "link" : this.editPage
                };
                gridDataObject.controlId = this.gridId;
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                return gridDataObject;

            case 1:

                var addLinkInfo = {
                    "text" : "Save",
                    "link" : this.centralPage,
                    "commandId" : 'jobQualificationAdd',
                    "targetControlId" : this.gridJobQualification,
                    "callback" : saveForm.toString()
                };

                var updateLinkInfo = {
                    "text" : "Update",
                    "link" : this.editPage
                };

                gridDataObject.model = model;
                gridDataObject.columns = columns;
                gridDataObject.gridUrl = this.gridUrl;
                gridDataObject.controlId = this.gridId;
                gridDataObject.appearance = globalCoreGridAppearanceToobarCreateCancel;
                gridDataObject.editorMode = "Insert";
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;

                return gridDataObject;

            case 2:

                var transport = {
                    read:  {
                        url: this.gridUrl + "/listByRefEntity?id=" + this.valueData,
                        dataType: "json"
                    },
                    update: {
                        url: this.gridUrl + "/saveOrUpdate",
                        dataType: "json"
                    },
                    destroy: {
                        url: this.gridUrl + "/delete",
                        dataType: "json"
                    },
                    createMessageBox: {
                        url: this.gridUrl + "/add",
                        dataType: "json"
                    }
                };

                var addLinkInfo =
                {
                    "text" : "Save",
                    "link" : this.centralPage,
                    "commandId" : 'branchUpdate',
                    "targetControlId" : this.gridJobQualification,
                    "callback" : updateBranch.toString()
                };

                var updateLinkInfo = {
                    "text" : "Update",
                    "link" : this.editPage
                };

                var transport = {
                    read:  {
                        url: this.gridUrl + "/listByRefEntity?id=" + this.valueData,
                        dataType: "json"
                    },
                    update: {
                        url: this.gridUrl + "/saveOrUpdate",
                        dataType: "json"
                    },
                    destroy: {
                        url: this.gridUrl + "/delete",
                        dataType: "json"
                    },
                    createMessageBox: {
                        url: this.gridUrl + "/add",
                        dataType: "json"
                    }
                };

                gridDataObject.model = model;
                gridDataObject.columns = columns;
                gridDataObject.gridUrl = this.gridInfoUrl;
                gridDataObject.controlId = this.gridId;
                gridDataObject.appearance = globalCoreGridAppearanceToobarCreateCancel;
                gridDataObject.editorMode = "Edit";
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                gridDataObject.transport = transport;
                gridDataObject.valueData = this.valueData;

                return gridDataObject;
        }
        return gridDataObject;
    }

   function saveForm()
   {
       var isValid = $("#" + "jobQualificationForm").validationEngine('validate');

       if (!isValid)
           return;

       if ($("#" + "jobQualificationForm").validationEngine('validate'));
       {

           var grid = $("#" + "gridJobQualification").data("kendoGrid").dataSource.data();

           var qualificationData;
           var status=false;
           var ajaxCore = new AjaxCore();

           $.each(grid, function (i, dataItem)
           {
               qualificationData = new Qualification();
               qualificationData.level = dataItem.level;
               qualificationData.fieldOfStudy = dataItem.fieldOfStudy;
               qualificationData.levelDescription = dataItem.levelDescription;
               qualificationData.fieldOfStudyDescription = dataItem.fieldOfStudyDescription;

               var request = ajaxCore.sendRequestType(globalHostname + "/app/Job/Qualification/add", qualificationData, "post");

               request.success(function(data, status, xhrObj)
               {
                   status = true;
               });
           });
           if (status)
               preparePageForLoading("branch.jsp");
       }
   }

   function updateForm()
   {
       alert('update form');
   }

}