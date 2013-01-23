var JobSetupCommandViewModel = function () {

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

        var jobSetupQualificationLinkInfo = {
            "text":"Add Qualification",
            "icon":"icon-plus",
            "commandId":'jobSetupQualificationAdd',
            "link":this.addPage,
            "ctrlId":"jobSetupQualificationAddId",
            "callback":function () {
                getJobSetupQualificationForm();
            }
        };

        var residenceLinkInfo = {
            "text":"Add Experience",
            "icon":"icon-plus",
            "commandId":'jobSetupExpertiseAdd',
            "link":this.addPage,
            "ctrlId":"jobSetupExpertiseAddId",
            "callback":function () {
                getExpertiseForm();
            }
        };

        var familyLinkInfo = {
            "text":"Add Skill",
            "icon":"icon-plus",
            "commandId":'jobSetupSkillAdd',
            "link":this.addPage,
            "ctrlId":"jobSetupSkillAddId",
            "callback":function () {
                getSkillForm();
            }
        };


        var updateLinkInfo = {
            "text":"Update",
            "link":this.editPage
        };

        gridDataObject.controlId = this.gridId;

        gridDataObject.addLinkInfo = [];
        gridDataObject.addLinkInfo.push(jobSetupQualificationLinkInfo);
        gridDataObject.addLinkInfo.push(residenceLinkInfo);
        gridDataObject.addLinkInfo.push(familyLinkInfo);
        gridDataObject.updateLinkInfo = updateLinkInfo;
        return gridDataObject;

    }

    function getJobSetupQualificationForm() {

        var commandObject = {
            targetId:"formDiv",
            title:"Add Qualification",
            url:"jobSetupQualificationAdd.jsp"
        };
        var coreDialolg = new CoreDialog();
        coreDialolg.createLoadDialog(commandObject);
    }

    function getExpertiseForm() {
        var commandObject = {
            targetId:"formDiv",
            title:"Add Experience",
            url:"jobSetupExperienceAdd.jsp"
        };

        var coreDialolg = new CoreDialog();
        coreDialolg.createLoadDialog(commandObject);
    }

    function getSkillForm() {

        var commandObject = {
            targetId:"formDiv",
            title:"Add Skill",
            url:"jobSetupSkillAdd.jsp"
        };

        var coreDialolg = new CoreDialog();
        coreDialolg.createLoadDialog(commandObject);
    }
   
}