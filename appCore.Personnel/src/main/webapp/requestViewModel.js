var RequestViewModel = function(dataSource)
{
  var self = this; 

  self.initData = ko.observableArray(dataSource);

  self.remove = function(element) {
        alert(element);
		alert(element.nid);
		self.initData.remove(element);
    }

}