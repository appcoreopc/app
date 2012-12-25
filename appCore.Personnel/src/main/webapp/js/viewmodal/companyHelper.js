var CompanyHelper = function ()
{
    this.deleteCompany = function(id)
    {
        var companyId = { "id" : id };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalCompanyDeleteUrl, companyId, "get");
        request.success(function(data)
        {
            return data.messageCode;
        });
    }



    /*

     self.targetId = ko.observable();
     self.editMode = ko.observable();
     self.applicationScopeType = ko.observable();

     */

    this.getCodeType = function(globalViewModal, id)
    {
        var companyId = { "id" : id };
        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestSequential(globalCompanyDeleteUrl, companyId, "get");
        request.success(function(data)
        {
            return data.messageCode;
        });
    }

}