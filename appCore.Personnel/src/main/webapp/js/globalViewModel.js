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

    // notification indicator like facebook
    self.notifications = ko.observable();

    self.errorMessage = ko.observable();

    self.recentItem = ko.observable();

    self.bindedViewModel = ko.observable();

    self.showStatus = function (message, functionCall) {

    }

    self.addToRecentItem = function () {
        var recentItem = new RecentItemModel();
        recentItem.applicationScopeType = self.applicationScopeType();
        recentItem.editMode = self.editMode();
        recentItem.companyName = self.companyName();
        recentItem.companyId = self.companyId();
        recentItem.targetId = self.targetId();
        self.recentItem(recentItem); // notify change
    }
}