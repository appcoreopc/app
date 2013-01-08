/*
 Industry
 Gender
 Race
 salutation
 Religion
 Nationality
 Maritalstatus
 Level
 Fieldofexpertise
 Familyrelationtype

 */

var CodeMaintenanceHelper = function (codeType)
{
    this.gridUrl = globalHostname + "/app/Job/";
    this.getUrl = function()
    {
        switch (codeType)
        {
            case 1:
                return this.gridUrl + "Industry";
            case 2:
                return this.gridUrl + "Gender";
            case 3:
                return this.gridUrl + "Race";
            case 4:
                return this.gridUrl + "Salutation";
            case 5:
                return this.gridUrl + "Religion";
            case 6:
                return this.gridUrl + "Nationality";
            case 7:
                return this.gridUrl + "MaritalStatus";
            case 8:
                return this.gridUrl + "Level";
            case 9:
                return this.gridUrl + "FieldOfExpertise";
            case 10:
                return this.gridUrl + "FamilyRelationType";
            case 11:
                return this.gridUrl + "EmployeeGroup";
            case 12:
                return globalHostname + "/app/Core/Calendar/" + "HolidayGroup";
            case 13:
                return this.gridUrl + "Currency";
        }
    }

    this.getTitle = function(codeType)
    {
        switch (codeType)
        {
            case 1:
                return "Industry";
            case 2:
                return "Gender";
            case 3:
                return "Race";
            case 4:
                return "Salutation";
            case 5:
                return "Religion";
            case 6:
                return "Nationality";
            case 7:
                return "Marital Status";
            case 8:
                return "Level";
            case 9:
                return "Field Of Expertise";
            case 10:
                return "Family Relation Type";
            case 11:
                return "Employee Group";
            case 12:
                return "Holiday Group";
            case 13:
                return "Currency";
        }
    }

    this.deletMaintenanceCode = function(companyId, id, codeType)
    {
        var maintenanceCodeObject = { companyId: companyId,  "id" : id };
        var url = this.getUrl(codeType);

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(url + "/delete", maintenanceCodeObject, "get");
        request.success(function(data)
        {
            return data.messageCode;
        })
    }

}