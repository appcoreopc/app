var JobExperienceViewModel = function(initView, value, data)
{

    this.viewType = initView;

    this.centralPage = "jobSetup.jsp";
    this.editPage = "jobSetupEdit.jsp";
    this.addPage = "jobSetupAdd.jsp";
    this.branchForm = "jobSetupForm";

    this.gridUrl = globalHostname + "/app/Job/Experience";
    this.gridJobExperience = "#experienceCommand";
    this.gridId = "gridJobExperience";
    this.data = data;

    var model =
    {
        id: "nid",
        fields: {
            nid: { editable: false },
            expertise : { editable: true, type: "string" },
            yearOfExpertise : { editable: true, type: "number", validation: { required: true } },
            expertiseDescription : { editable: true, type: "string" }
        }
    };

    var columns = { "columns" : [
        {
            field: "expertise",
            width: 90,
            title: "Expertise"
        },
        {
            field: "yearOfExpertise",
            width: 90,
            title: "Year of Experience"
        },
        {
            field: "expertiseDescription",
            width: 90,
            title: "Expertise Description"
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

        switch (this.viewType)
        {
            case 0:

                var addLinkInfo = {
                    "text" : "Save",
                    "commandId" : 'jobExperienceAdd',
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
                    "commandId" : 'jobExperienceAdd',
                    "targetControlId" : this.gridJobExperience,
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
                    "commandId" : 'jobExperienceUpdate',
                    "targetControlId" : this.gridJobExperience,
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

       var isValid = $("#" + "jobExperienceForm").validationEngine('validate');

       if (!isValid)
           return;

       if ($("#" + "jobExperienceForm").validationEngine('validate'));
       {

           var grid = $("#" + "gridJobExperience").data("kendoGrid").dataSource.data();

           var experienceData;
           var status=false;
           var ajaxCore = new AjaxCore();

           $.each(grid, function (i, dataItem)
           {
               experienceData = new Experience();
               experienceData.expertise = dataItem.expertise;
               experienceData.yearOfExpertise = dataItem.yearOfExpertise;
               experienceData.expertiseDescription = dataItem.expertiseDescription;

               var request = ajaxCore.sendRequestType(globalHostname + "/app/Job/Experience/add", experienceData, "post");

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

   function goToAdd()
   {
       alert('gotoadd');
   }
}