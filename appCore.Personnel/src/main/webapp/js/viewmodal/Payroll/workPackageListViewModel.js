 var WorkPackageListViewModel = function (initView, data, globalViewModel, command) { 
    
	  mode = initView;
    var self = this;
    self.gridUrl = globalHostname + "/app/Core/WorkPackage";
    self.codeCommand = "#codeCommand";
    self.gridId = "gridWorkPackage";
    self.data = data;
    self.gridData = ko.observableArray(data);
    self.globalViewModel = globalViewModel;
    self.coreCommand = command;

		
    var viewColumns = [
				
     { headerText:"nid", rowText:"nid" },
				    		
     { headerText:"name", rowText:"name" },
				    		
     { headerText:"description", rowText:"description" },
				    		
     { headerText:"application", rowText:"application" },
				    		
     { headerText:"status", rowText:"status" },
				    		
     { headerText:"setupType", rowText:"setupType" },
				    		
     { headerText:"typeRefId", rowText:"typeRefId" },
				    		
     { headerText:"lastUpdate", rowText:"lastUpdate" },
				    		
     { headerText:"companyId", rowText:"companyId" }    			    
    ];
		
    function getView() {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data
        };

        switch (mode) {
            case 0:
                var addLinkInfo = {
                    "text":"Add WorkPackage",
                    "commandId":'WorkPackageAdd',
                    "callback":function () {
                        goToAdd()
                    }
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.gridData = self.gridData;
                gridDataObject.viewColumns = viewColumns;
                gridDataObject.updateFunction = updateFunction;
                gridDataObject.deleteFunction = deleteFunction;
                gridDataObject.controlId = this.gridId;
                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                return gridDataObject;
        }
        return gridDataObject;
    }

    self.initializeViewModel = function () {
        var gridDataObject = getView();
        var input = { "id":coreBranchPage, "roleId":globalViewModel.employeeRole() };
        var gridViewModel = self.coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        self.gridViewModel = gridViewModel;
    }

    function deleteFunction(data) {
        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove this record?");
        var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, null, deleteCallBack);
    }

    function deleteCallBack(status, data, globalViewModel, codeType) {
        if (status == true) {
            var helper = new CompanyHelper();
            var result = helper.deleteWorkPackage(data, successDeleteCallback);
        }
    }

    function successDeleteCallback(result, data) {
        if (result.messageCode == 0) {
            self.gridData.remove(data);
        }
    }

    function updateFunction(data) {
        globalViewModel.targetId(data.nid);
        globalViewModel.editMode(coreModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeWorkPackageType);
        preparePageForLoading("workPackageAdd.jsp");
    }

    function goToAdd() {
        globalViewModel.applicationScopeType(coreApplicationTypeWorkPackageType);
        globalViewModel.editMode(coreModeInsert);
        preparePageForLoading("workPackageAdd.jsp");
    }

    self.initializeViewModel();
}