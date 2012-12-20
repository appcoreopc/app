    <script language="javascript" src="../../js/coreComboControl.js"></script>

        <link rel="stylesheet" href="../../css/fontello.css"><!--[if IE 7]>
        <link rel="stylesheet" href="../../css/fontello-ie7.css"><![endif]-->

        <script type="text/javascript">

        var ctl = new ComboControl();
        ctl.createControl(dataObjects);

        var d = {
        "url" : url,
        "icon" : "icon-th-large-1",
        "targetControlId" : "viewPort",
        "data" : null,
        "key" : "nid",
        "text" : "companyCode",
        "title" : "Holiday Group",
        "clickControlId" : "alinkAdd",
        "clickCode" : function()
            {
                preparePageForLoading("branchAdd.jsp");
            }
        };

        var widget = new WidgetCommandControl();
        widget.createControl(d);
        widget.createControl(d);
        widget.createControl(d);
        widget.createControl(d);
    </script>

