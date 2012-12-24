var EmployeeViewModel = function (initView, globalViewModel) {

    this.viewType = initView;
    this.centralPage = "employeeAdd.jsp";
    this.editPage = "employeeAdd.jsp";
    this.addPage = "branchAdd.jsp";
    this.branchForm = "branchForm";
    this.gridUrl = globalEmployeeUrl;
    this.codeCommand = "#codeCommand";
    this.gridId = "gridBranch";

    this.data = null;

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

    var infoColumns = { "columns":[
        {
            field:"type",
            width:90,
            title:"Type"
        },
        {
            field:"value",
            width:90,
            title:"Value"
        },
        {
            field:"description",
            width:90,
            title:"Description"
        },
        {
            field:"category",
            width:90,
            title:"Category"
        }

    ]};

    var infoModel =
    {
        id:"nid",
        fields:{
            nid:{ editable:false },
            type:{  type:"string" },
            value:{  validation:{ required:true } },
            description:{  type:"string" },
            category:{  validation:{ required:true } }
        }
    };

    if (globalViewModel != undefined) {

        globalViewModel.companyId.subscribe(function (newValue) {
            $(".maintenanceCommand").empty();
            $("#employeeListViewGrid").empty();
            generateEmployeeGrid(newValue);
        });
    }



    this.getAddPage = function () {
        return this.addPage;
    }

    this.getCentralPage = function () {
        return this.centralPage;
    }

    function goToAdd() {
        globalFormMode = 1;
        preparePageForLoading("employeeGeneralInfoView.jsp");
    }

    this.getListView = function (companyId) {
        generateEmployeeGrid(companyId);
    }

    function generateEmployeeGrid(companyId) {
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmployeeUrl + "/list", null, "get");

        request.success(function (dataSource) {
            var gridMetaData =
            {
                "gridUrl":globalEmployeeUrl,
                "data":dataSource,
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

            var input = { "id":coreEmployeePage, "roleId":1 };
            var coreCommand = new CoreCommand();
            coreCommand.parseCommand(hostAuthorizationUrl, input, gridMetaData);

        });
    }

    this.getView = function () {

        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":columns,
            "model":model
        };

        switch (this.viewType) {
            case 0:
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
}