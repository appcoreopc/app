    <style>
        body { font-family: arial; font-size: 14px; }

        .liveExample { padding: 1em; background-color: #EEEEDD; border: 1px solid #CCC; max-width: 655px; }
        .liveExample input { font-family: Arial; }
        .liveExample b { font-weight: bold; }
        .liveExample p { margin-top: 0.9em; margin-bottom: 0.9em; }
        .liveExample select[multiple] { width: 100%; height: 8em; }
        .liveExample h2 { margin-top: 0.4em; }


        .ko-grid { margin-bottom: 1em; width: 25em; border: 1px solid silver; background-color:White; }
        .ko-grid th { text-align:left; background-color: Black; color:White; }
        .ko-grid td, th { padding: 0.4em; }
        .ko-grid tr:nth-child(odd) { background-color: #DDD; }
        .ko-grid-pageLinks { margin-bottom: 1em; }
        .ko-grid-pageLinks a { padding: 0.5em; }
        .ko-grid-pageLinks a.selected { background-color: Black; color: White; }
        .liveExample { height:20em; overflow:auto } /* Mobile Safari reflows pages slowly, so fix the height to avoid
        the need for reflows */

        li { list-style-type: disc; margin-left: 20px; }
        ​

        </style>

        <script language="javascript" src="../../js/viewmodal/branchViewModel.js"></script>

        <script src="../../js/jquery-1.7.2.min.js"></script>

        <script language="javascript" src="../../js/ui/jquery-ui-1.8.23.custom.min.js"></script>
        <script language="javascript" src="../../js/viewmodal/knockoutBindersControl.js"></script>
        <script src="../../kendo/js/kendo.web.min.js"></script>
        <script language="javascript" src="../../js/knockoutjs/knockout-2.2.0.debug.js"></script>
        <script language="javascript" src="../../js/simpleGrid.js"></script>


        <script type="text/javascript">
        $(document).ready(function()
        {
        var initialData = [
        { name: "Well-Travelled Kitt", sales: 352, price: 75.95 },
        { name: "Speedy Coyote", sales: 89, price: 190.00 },
        { name: "Furious Lizard", sales: 152, price: 25.00 },
        { name: "Indifferent Monkey", sales: 1, price: 99.95 },
        { name: "Brooding Dragon", sales: 0, price: 6350 },
        { name: "Ingenious Tadpole", sales: 39450, price: 0.35 },
        { name: "Optimistic Snail", sales: 420, price: 1.50 }
        ];

        var PagedGridModel = function(items) {

        var self = this;

        self.items = ko.observableArray(items);

        self.addItem = function()
        {
            self.items.push({ name: "New item", sales: 0, price: 100 });
        };

        self.sortByName = function() {
        self.items.sort(function(a, b) {
            return a.name < b.name ? -1 : 1;
        });
        };

        self.jumpToFirstPage = function()
        {
            this.gridViewModel.currentPageIndex(0);
        };

        self.disableDelete = function()
        {
            this.gridViewModel.enableDelete(false);
        }



        var self = this;
        self.name = "namenamename";
        self.name2 = "noname";
        var miki="testing";


        this.gridViewModel = new ko.dataGrid.ViewModel({
        data: self.items,
        columns: [
        { headerText: "Item Name", rowText: "name" },
        { headerText: "Sales Count", rowText: "sales" },
        { headerText: "Price", rowText: function (item) { return "$" + item.price.toFixed(2) } }
        ],
        pageSize: 10,
        enableUpdate : ko.observable(false),
        enableAdd : ko.observable(false),
        enableDelete : ko.observable(true),
        deleteData : function(data)
        {
            self.items.remove(data);
        },
        updateData : function(data) { alert(data);}
        });
        };



        var vm = new PagedGridModel(initialData);
        ko.applyBindings(vm);

        });

        </script>


        <div data-bind='dataGrid: gridViewModel'> </div>

        <button data-bind='click: addItem'>
        Add item
        </button>

        <button data-bind='click: sortByName'>
        Sort by name
        </button>

        <button data-bind='click: disableDelete'>
        Disable Delete
        </button>


        <button data-bind='click: jumpToFirstPage, enable: gridViewModel.currentPageIndex'>
        Jump to first page
        </button>