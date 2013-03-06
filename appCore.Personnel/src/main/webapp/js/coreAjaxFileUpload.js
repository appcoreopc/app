(function ($) {

    $.fn.activateFileUpload = function (targetFormId, uploadPath) {

        $(':file').change(function () {
            var file = this.files[0];
            name = file.name;
            size = file.size;
            type = file.type;

            if (file.name.length < 1) {
            }
            else if (file.size > 1000000) {
                alert("File is to big");
            }
            else if (file.type != 'image/png' && file.type != 'image/jpg' && !file.type != 'image/gif' && file.type != 'image/jpeg') {
                alert("File doesn't match png, jpg or gif");
            }
            else {
                //$('#uploadFileBtn').click(function ()
                //{
                //var formData = new FormData($("#myform")[0]);
                //var formData = new FormData($('form')[0]);
                var formData = new FormData($('#' + targetFormId)[0]);
                console.log(formData);

                $.ajax({
                    url:uploadPath, //server script to process data
                    type:'POST',
                    xhr:function () {  // custom xhr
                        var myXhr = $.ajaxSettings.xhr();
                        if (myXhr.upload) {
                            //if upload property exists
                            //myXhr.upload.addEventListener('progress', progressHandlingFunction, false); // progressbar
                        }
                        return myXhr;
                    },
                    //Ajax events
                    success:function (data) {
                        //alert('done!');
                        /*
                         * workaround for crome browser // delete the fakepath
                         */
                        if (navigator.userAgent.indexOf('Chrome')) {
                            var catchFile = $(":file").val().replace(/C:\\fakepath\\/i, '');
                        }
                        else {
                            var catchFile = $(":file").val();
                        }
                        //var writeFile = $(":file");
                        //writeFile.html(writer(catchFile));
                        //$("*setIdOfImageInHiddenInput*").val(data.logo_id);
                    },
                    error:function () {
                        alert("uh error");
                    },
                    // Form data
                    data:formData,
                    //Options to tell JQuery not to process data or worry about content-type
                    cache:false,
                    contentType:false,
                    processData:false
                }, 'json');
                //});
            }
        });
    }

})(jQuery);