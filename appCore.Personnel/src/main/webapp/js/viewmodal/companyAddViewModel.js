var CompanyAddViewModel = function (mode, companyId) {

    var self = this;
    var modelCompanyId = companyId;

    self.mode = ko.observable(0);

    self.nid = ko.observable();

    self.companyCode = ko.observable();
    self.companyName = ko.observable();
    self.registration = ko.observable();

    self.address = ko.observable();
    self.address2 = ko.observable();
    self.address3 = ko.observable();
    self.city = ko.observable();

    self.country = ko.observable();
    self.postcode = ko.observable();
    self.tel = ko.observable();
    self.fax = ko.observable();

    self.parentCompany = ko.observable();
    self.defaultCurrency = ko.observable();
    self.disabled = ko.observable();

    self.templateToUse = ko.observable();

    this.centralPage = globalCompanyCentralPage;

    self.mode(mode);

    if (mode == 2) {
        getCompany(modelCompanyId);
    }

    function getCompany(companyId) {

        var ajaxCore = new AjaxCore();
        var companyRequest = { id:companyId };

        var request = ajaxCore.sendRequest(globalCompanyGetUrl, companyRequest, "get");

        request.success(function (dataSource) {
            self.nid(dataSource.nid);

            self.companyCode(dataSource.companyCode);
            self.companyName(dataSource.companyName);
            self.registration(dataSource.registration);

            self.address(dataSource.address);
            self.address2(dataSource.address2);
            self.address3(dataSource.address3);

            self.city(dataSource.city);
            self.country(dataSource.country);
            self.postcode(dataSource.postcode);
            self.tel(dataSource.tel);
            self.fax(dataSource.fax);

            self.parentCompany(dataSource.parentCompany);
            self.defaultCurrency(dataSource.defaultCurrency);
            self.disabled(dataSource.disabled);

        });
    }


    this.getView = function () {
        var gridDataObject =
        {
            "gridUrl":this.gridUrl,
            "data":this.data,
            "columns":null,
            "model":null
        };

        switch (self.mode()) {
            case 1:

                var addLinkInfo = {
                    "text":"Save",
                    "link":this.centralPage,
                    "commandId":'codeAdd',
                    "targetControlId":"#maintenanceCodeCommand",
                    "knockoutAttribute":"click: saveOrUpdateCompany"
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                gridDataObject.editorMode = "Insert";
                return gridDataObject;

            case 2:

                var addLinkInfo = {
                    "text":"Save",
                    "link":this.centralPage,
                    "commandId":'codeAdd',
                    "targetControlId":"#maintenanceCodeCommand",
                    "knockoutAttribute":"click: saveOrUpdateCompany"
                };

                var updateLinkInfo = {
                    "text":"Update",
                    "link":this.editPage
                };

                gridDataObject.addLinkInfo = addLinkInfo;
                gridDataObject.updateLinkInfo = updateLinkInfo;
                gridDataObject.editorMode = "Insert";
                return gridDataObject;

            default:
                return null;

        }
    }


    this.saveOrUpdateCompany = function () {

        var isValid = $("#" + "companyForm").validationEngine('validate');

        if (!isValid)
        {
            alert('invalid validation.')
            return;
        }

        var company = new Company();

        if (self.mode() == 2) {
            company.nid = self.nid();
        }

        company.companyCode = self.companyCode();
        company.companyName = self.companyName();

        company.address = self.address();
        company.address2 = self.address2();
        company.address3 = self.address3();

        company.city = self.city();
        company.country = self.country();
        company.defaultCurrency = self.defaultCurrency();
        company.postcode = self.postcode();
        company.registration = self.registration();
        company.parentCompany = self.parentCompany();
        company.tel = self.tel();
        company.fax = self.fax();
        company.disabled = self.disabled();

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequestType(globalCompanySaveOrUpdateUrl, company, "post");

        request.success(function (dataSource) {
            globalCurrentId = null;
            goToPage(globalPersonnelControlPanel);
        });
    }
}