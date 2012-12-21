<script language="javascript" src="../../js/viewmodal/branchViewModel.js"></script>

    <script src="../../js/jquery-1.7.2.min.js"></script>


    <script language="javascript" src="../../js/ui/jquery-ui-1.8.23.custom.min.js"></script>

    <script language="javascript" src="../../js/viewmodal/knockoutBindersControl.js"></script>


    <script src="../../kendo/js/kendo.web.min.js"></script>
    <script language="javascript" src="../../js/knockoutjs/knockout-2.2.0.debug.js"></script>

<script type="text/javascript">          


    /*
    var Detail = function(subscription)
    {
        var self = this;

        subscription.subscribe(function (newValue)
        {
            if (newValue==1)
            {
                        self.companyName("Microsoft");
            }
            else if (newValue==2)
            {
                    self.companyName("Google");
            }
        });

        self.companyName = ko.observable();

    }
*/


    var Detail = function(subscription)
    {
    var self = this;

    subscription.subscribe(function (newValue)
    {
    if (newValue==1)
    {
    self.companyName("Microsoft");
    }
    else if (newValue==2)
    {
    self.companyName("Google");
    }
    });

    self.companyName = ko.observable();

    }


    $(document).ready(function()
	{
            var vm = {
                companyCode : ko.observable(1)
            };

    var child = new Detail(vm.companyCode);

    ko.applyBindings(vm, document.getElementById("Summary"));
    ko.applyBindings(child, document.getElementById("Details"));


   	});
			
</script>    

<div class="form formOutline">


    <div class="viewData">

    <div id="Summary">
    <div id="gridBranch" style="height: 380px">
    <input type="text" data-bind="value : companyCode" />
    </div>
    </div>


    <div id="Details">

    <span data-bind="text : companyName"></span>

    </div>


    <div>
</div>
