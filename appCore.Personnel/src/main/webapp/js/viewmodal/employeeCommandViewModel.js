var EmployeeCommandViewModel = function () {

    var self = this;
    self.centralPage = "employeeAdd.jsp";
    self.editPage = "employeeAdd.jsp";
    self.addPage = "branchAdd.jsp";
    self.branchForm = "branchForm";
    self.gridUrl = globalEmployeeUrl;
    self.codeCommand = "#codeCommand";
    self.gridId = "gridBranch";

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

    function goToAdd() {
        globalViewModel.targetId(null);
        globalViewModel.editMode(coreModeInsert);
        globalViewModel.applicationScopeType(coreApplicationTypeEmployee);
        preparePageForLoading("employeeGeneralInfoView.jsp");
    }

    self.getCommandForForm = function () {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":columns,
            "model":model
        };

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
        };

        var membershipLinkInfo = {
            "text":"Add Membership",
            "icon":"icon-plus",
            "commandId":'MembershipAdd',
            "link":this.addPage,
            "ctrlId":"membershipAddId",
            "callback":function () {
                getMembershipForm();
            }
        };

        var fieldExpertiseLinkInfo = {
            "text":"Add Expertise",
            "icon":"icon-plus",
            "commandId":'ExpertiseAdd',
            "link":this.addPage,
            "ctrlId":"expertiseAddId",
            "callback":function () {
                getExpertiseForm();
            }
        };

        var previousEmploymentLinkInfo = {
            "text":"Add Employment History",
            "icon":"icon-plus",
            "commandId":'employmentHistoryAdd',
            "link":this.addPage,
            "ctrlId":"previousEmploymentAddId",
            "callback":function () {
                getPreviousEmploymentForm();
            }
        };

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