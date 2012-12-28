var EmployeeViewModel = function (initView, globalViewModel, data) {

    var self = this;
    self.mode = initView;
    self.centralPage = "employeeAdd.jsp";
    self.editPage = "employeeAdd.jsp";
    self.addPage = "branchAdd.jsp";
    self.branchForm = "branchForm";
    self.gridUrl = globalEmployeeUrl;
    self.codeCommand = "#codeCommand";
    self.gridId = "gridBranch";

    this.data = null;

    self.gridData = ko.observableArray(data);
    self.globalViewModel = globalViewModel;

    self.enableAdd = ko.observable();
    self.enableUpdate = ko.observable();
    self.enableDelete = ko.observable();

    var viewColumns = [
        { headerText:"Employee Code", rowText:"code" },
        { headerText:"Employee Name", rowText:"name" },
        { headerText:"Gender", rowText:"gender" },
        { headerText:"Age", rowText:"age" }
    ];

    var model =
    {
        id:"nid",
        fields:{
            nid:{ editable:false },
            code:{ editable:false, type:"string" },
            name:{ editable:false, validation:{ required:true } },
            gender:{ editable:false, type:"string" },
            age:{ editable:false, validation:{ required:true } }
        }
    };

    var columns = { "columns":[
        {
            field:"code",
            width:90,
            title:"Code"
        },
        {
            field:"name",
            width:90,
            title:"Name"
        },
        {
            field:"gender",
            width:90,
            title:"Gender"
        },
        {
            field:"age",
            width:90,
            title:"Age"
        }
    ]};

    /*if (globalViewModel != undefined)
     {
     globalViewModel.companyId.subscribe(function (newValue) {
     $(".maintenanceCommand").empty();
     $("#employeeListViewGrid").empty();
     generateEmployeeGrid(newValue);
     });

     } */

    function goToAdd() {
        globalViewModel.targetId(null);
        globalViewModel.editMode(coreModeInsert);
        globalViewModel.applicationScopeType(coreApplicationTypeEmployee);
        preparePageForLoading("employeeGeneralInfoView.jsp");
    }

    function updateFunction(data) {

        globalViewModel.targetId(data.nid);
        globalViewModel.editMode(coreModeEdit);
        globalViewModel.applicationScopeType(coreApplicationTypeEmployee);
        //preparePageForLoading("employeeGeneralInfoView.jsp");
        preparePageForLoading("employeeAdd.jsp");
    }

    function deleteFunction(data) {
        var dialog = new CoreDialog();
        var helper = new EmployeeHelper();
        var dialogObject = helper.createDialogObject("Delete record", "Do you want to remove this record?");
        var result = dialog.createConfirmationDialog(dialogObject, data, globalViewModel, null, deleteCallBack);
    }

    function deleteCallBack(status, data, globalViewModel, codeType) {
        if (status == true) {
            var helper = new EmployeeHelper();
            var result = helper.deleteEmployee(data, successDeleteCallback);
        }
    }

    function successDeleteCallback(result, data) {
        if (result.messageCode == 0) {
            self.gridData.remove(data);
        }
    }

    self.getListView = function (companyId) {
        return generateEmployeeGrid(companyId);
    }

    function generateEmployeeGrid(companyId) {

        //var ajaxCore = new AjaxCore();
        //var request = ajaxCore.sendRequest(globalEmployeeListByCompanyUrl, null, "get");
        //request.success(function (dataSource) {

        var gridMetaData =
        {
            "gridUrl":globalEmployeeUrl,
            "data":self.gridData,
            "columns":columns,
            "model":model
        };

        var addLinkInfo = {
            "text":"Add Employee",
            "commandId":'employeeAdd',
            "link":this.addPage,
            "callback":function () {
                goToAdd();
            }
        };

        var updateLinkInfo = {
            "text":"Update",
            "link":"employeeAdd.jsp"
        };

        gridMetaData.controlId = "employeeListViewGrid";
        gridMetaData.addLinkInfo = addLinkInfo;
        gridMetaData.updateLinkInfo = updateLinkInfo;
        gridMetaData.gridData = self.gridData;
        gridMetaData.viewColumns = viewColumns;
        gridMetaData.updateFunction = updateFunction;
        gridMetaData.deleteFunction = deleteFunction;

        /*var input = { "id":coreEmployeePage, "roleId":1 };
         var coreCommand = new CoreCommand();
         coreCommand.parseCommand(hostAuthorizationUrl, input, gridMetaData);
         */
        return gridMetaData;
        //});
    }

    /*self.getCommandForForm = function () {

        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":columns,
            "model":model
        };

        switch (this.mode) {
            case 1:
                var contactLinkInfo = {
                    "text":"Add Contact",
                    "icon":"icon-plus",
                    "commandId":'contactAdd',
                    "link":this.addPage,
                    "ctrlId":"contactAddId",
                    "callback":function () {
                        getContactForm();
                    }
                };

                var residenceLinkInfo = {
                    "text":"Add Residential Information",
                    "icon":"icon-plus",
                    "commandId":'residenceAdd',
                    "link":this.addPage,
                    "ctrlId":"residenceAddId",
                    "callback":function () {
                        getResidenceForm();
                    }
                };

                var familyLinkInfo = {
                    "text":"Add Family",
                    "icon":"icon-plus",
                    "commandId":'familyAdd',
                    "link":this.addPage,
                    "ctrlId":"familyAddId",
                    "callback":function () {
                        getFamilyForm();
                    }
                };

                var qualificationLinkInfo = {
                    "text":"Add Qualification",
                    "icon":"icon-plus",
                    "commandId":'QualificationAdd',
                    "link":this.addPage,
                    "ctrlId":"qualificationAddId",
                    "callback":function () {
                        getQualificationForm();
                    }
                }

                var membershipLinkInfo = {
                    "text":"Add Membership",
                    "icon":"icon-plus",
                    "commandId":'MembershipAdd',
                    "link":this.addPage,
                    "ctrlId":"membershipAddId",
                    "callback":function () {
                        getMembershipForm();
                    }
                }

                var fieldExpertiseLinkInfo = {
                    "text":"Add Expertise",
                    "icon":"icon-plus",
                    "commandId":'ExpertiseAdd',
                    "link":this.addPage,
                    "ctrlId":"expertiseAddId",
                    "callback":function () {
                        getExpertiseForm();
                    }
                }

                var previousEmploymentLinkInfo = {
                    "text":"Add Employment History",
                    "icon":"icon-plus",
                    "commandId":'employmentHistoryAdd',
                    "link":this.addPage,
                    "ctrlId":"previousEmploymentAddId",
                    "callback":function () {
                        getPreviousEmploymentForm();
                    }
                }

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.controlId = this.gridId;

                gridDataObject.addLinkInfo = [];

                gridDataObject.addLinkInfo.push(contactLinkInfo);
                gridDataObject.addLinkInfo.push(residenceLinkInfo);
                gridDataObject.addLinkInfo.push(familyLinkInfo);
                gridDataObject.addLinkInfo.push(qualificationLinkInfo);
                gridDataObject.addLinkInfo.push(membershipLinkInfo);
                gridDataObject.addLinkInfo.push(fieldExpertiseLinkInfo);
                gridDataObject.addLinkInfo.push(previousEmploymentLinkInfo);

                gridDataObject.updateLinkInfo = updateLinkInfo;

                return gridDataObject;
        }


        function getContactForm() {

            var commandObject = {
                targetId:"formDiv",
                title:"Contact",
                url:"employeeAddContacts.jsp"
            };
            var coreDialolg = new CoreDialog();
            coreDialolg.createLoadDialog(commandObject);
        }

        function getResidenceForm() {
            var commandObject = {
                targetId:"formDiv",
                title:"Residence",
                url:"employeeAddResidenceInfo.jsp"
            };

            var coreDialolg = new CoreDialog();
            coreDialolg.createLoadDialog(commandObject);
        }

        function getFamilyForm() {

            var commandObject = {
                targetId:"formDiv",
                title:"Family",
                url:"employeeAddFamily.jsp"
            };

            var coreDialolg = new CoreDialog();
            coreDialolg.createLoadDialog(commandObject);
        }

        function getQualificationForm() {
            var commandObject = {
                targetId:"formDiv",
                title:"Qualification",
                url:"employeeAddQualification.jsp"
            };

            var coreDialolg = new CoreDialog();
            coreDialolg.createLoadDialog(commandObject);
        }

        function getMembershipForm() {
            var commandObject = {
                targetId:"formDiv",
                title:"Membership",
                url:"employeeAddMembership.jsp"
            };

            var coreDialolg = new CoreDialog();
            coreDialolg.createLoadDialog(commandObject);
        }

        function getExpertiseForm() {
            var commandObject = {
                targetId:"formDiv",
                title:"Expertise",
                url:"employeeAddExpertise.jsp"
            };

            var coreDialolg = new CoreDialog();
            coreDialolg.createLoadDialog(commandObject);
        }

        function getPreviousEmploymentForm() {
            var commandObject = {
                targetId:"formDiv",
                title:"Previous Employment",
                url:"employeeAddEmploymentInfo.jsp"
            };

            var coreDialolg = new CoreDialog();
            coreDialolg.createLoadDialog(commandObject);
        }
    }
*/

    self.initializeViewModel = function () {

        var gridDataObject = self.getListView();
        var input = { "id":coreEmployeePage, "roleId":globalViewModel.employeeRole() };
        var coreCommand = new CoreCommand();

        var gridViewModel = coreCommand.parseCommand(hostAuthorizationUrl, input, gridDataObject);
        var permissionResult = coreCommand.getPermission(hostAuthorizationUrl, input);

        self.gridViewModel = gridViewModel;

        var helper = new EmployeeHelper();
        self.enableAdd(helper.getEnableAdd(permissionResult.permission));
        self.enableUpdate(helper.getEnableUpdate(permissionResult.permission));
        self.enableDelete(helper.getEnableDelete(permissionResult.permission));

    }

    self.initializeViewModel();
}