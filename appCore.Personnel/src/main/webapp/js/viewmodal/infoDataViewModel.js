var InfoDataViewModel = function (element) {

    var self = this;
    self.nid = ko.observable(element.nid);
    self.infoCategory = ko.observable(element.category);
    self.infoDescription = ko.observable(element.description);
    self.infoType = ko.observable(element.type);
    self.infoValue = ko.observable(element.value);
}

