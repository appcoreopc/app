var GlobalViewModel = function () {

    var self = this;
    self.companyId = ko.observable();
    self.companyName = ko.observable();

    self.employeeRole = ko.observable();
    self.employeeId = ko.observable();
    self.username = ko.observable();

    self.targetId = ko.observable();
    self.editMode = ko.observable();
    self.applicationScopeType = ko.observable();
    self.refresh = ko.observable();

    self.previousBindeCcomponentId = "";
    // notification indicator like facebook
    self.notifications = ko.observable();

    self.errorMessage = ko.observable();

    self.showStatus = function(message, functionCall)
    {

    }

}