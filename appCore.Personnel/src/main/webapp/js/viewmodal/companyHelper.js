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
}