/*
 Need to create validator for
 a) number (indicate entry is for number)
 - Auto rounding (auto-correct maybe)
 b) date
 c) email
 d) link
 e) regex
 f) text - valid length (acceptable length)

 Sample usage :-

 data-bind="textedit : name, controlOptions : { validateType : 'required' }"

 */

ko.bindingHandlers.textedit = {

    init:function (element, valueAccessor, allBindingsAccessor) {

        function isEmpty(str) {
            return (!str || 0 === str.length);
        }

        function isInteger(n) {
            return n === +n && n === (n | 0);
        }

        function isFloat(n) {
            return n === +n && n !== (n | 0);
        }

        function parseMinValueMarkup(val) {
            return validationDelimiter + minValueValidationMarkupStart + val + minValueValidationMarkupEnd;
        }

        function parseMaxValueMarkup(val) {
            return validationDelimiter + maxValueValidationMarkupStart + val + maxValueValidationMarkupEnd;
        }

        function parseMinLengthMarkup(val) {
            return minLengthValidationMarkupStart + val + minLengthValidationMarkupEnd;
        }

        function parseMaxLengthMarkup(val) {
            return maxLengthValidationMarkupStart + val + maxLengthValidationMarkupEnd;
        }

        function parseMinMaxValueMarkup(min, max) {
            var minMaxValidationStr = "";
            var needParseDelimiter = false;

            if (min != undefined) {
                if (isInteger(min)) {
                    minMaxValidationStr += parseMinValueMarkup(min);
                    needParseDelimiter = true;
                }
            }

            if (max != undefined) {
                if (isInteger(max)) {
                    if (needParseDelimiter == true) {
                        minMaxValidationStr += validationDelimiter;
                    }
                    minMaxValidationStr += parseMaxValueMarkup(max);
                }
            }
            return minMaxValidationStr;
        }

        function parseMinMaxLengthMarkup(min, max) {
            var minMaxValidationStr = "";
            var needParseDelimiter = false;

            if (min != undefined) {
                if (isInteger(min)) {
                    minMaxValidationStr += parseMinLengthMarkup(min);
                    needParseDelimiter = true;
                }
            }

            if (max != undefined) {
                if (isInteger(max)) {
                    if (needParseDelimiter == true) {
                        minMaxValidationStr += validationDelimiter;
                    }
                    minMaxValidationStr += parseMaxLengthMarkup(max);
                }
            }

            return minMaxValidationStr;
        }

        var options = allBindingsAccessor().controlOptions;

        var minValueValidationMarkupStart = "min["
        var minValueValidationMarkupEnd = "]"

        var maxValueValidationMarkupStart = "max["
        var maxValueValidationMarkupEnd = "]"

        var maxLengthValidationMarkupStart = "maxSize["
        var maxLengthValidationMarkupEnd = "]"

        var minLengthValidationMarkupStart = "minSize["
        var minLengthValidationMarkupEnd = "]"

        var textEditCaption = options.caption;
        var validationType = options.validateType;

        var minVal = options.minValue;
        var maxVal = options.maxValue;

        var minLength = options.minLength;
        var maxLength = options.maxLength;


        if (textEditCaption == undefined) {
            textEditCaption = "";
        }

        var labelHtmlCodeBlockStart = "<div class='labelSectionBlockBold'>";
        var labelHtmlRequiredCodeBlockStart = labelHtmlCodeBlockStart + "<i class='icon-asterisk'></i>";
        var labelHtmlCodeBlockEnd = "</div>";

        // required validation markup
        var validationMarkupStart = "validate[";
        var validationMarkupEnd = "]";
        var requiredValidationMarkup = "[required]";
        var emailValidationMarkup = "[custom[email]";
        var urlValidationMarkup = "[custom[url";
        var numberValidationMarkup = "[custom[number]";
        var integerValidationMarkup = "[custom[integer]";
        var validationDelimiter = ",";
        var validationRequiredString = validationMarkupStart;
        var appendedValidationString = "";

        var emptyValidation = false;

        if (options != undefined) {

            if (validationType == 'required') {
                appendedValidationString += requiredValidationMarkup;
            }
            else if (validationType == 'number') {
                appendedValidationString += numberValidationMarkup;
                appendedValidationString += parseMinMaxValueMarkup(minVal, maxVal);

            }
            else if (validationType == 'integer') {
                appendedValidationString += integerValidationMarkup;
                appendedValidationString += parseMinMaxValueMarkup(minVal, maxVal);
            }
            else if (validationType == 'url') {
                appendedValidationString = urlValidationMarkup;
            }
            else if (validationType == 'email') {
                appendedValidationString = emailValidationMarkup;
            }
            else {

                var parseResult = parseMinMaxLengthMarkup(minLength, maxLength);
                if (isEmpty(parseResult)) {
                    emptyValidation = true;
                }
                else {
                    appendedValidationString += parseResult;
                }
            }

            $(element).parent().before(labelHtmlRequiredCodeBlockStart + textEditCaption + labelHtmlCodeBlockEnd);

            if (emptyValidation) {

            }
            else {
                validationRequiredString += appendedValidationString
                validationRequiredString += validationMarkupEnd;
                $(element).addClass(validationRequiredString);
            }
        }

        var value = ko.utils.unwrapObservable(valueAccessor());
        //handle the field changing
        ko.utils.registerEventHandler(element, "change", function () {
            var observable = valueAccessor();
            observable($(element).val());
        });

        //handle disposal (if KO removes by the template binding)
        ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
            $(element).datepicker("destroy");
        });

    },
    update:function (element, valueAccessor, allBindingsAccessor, viewModel) {

        var attentionGrabbingColorDefinition = "#C09853";
        var okColorDefinition = "#7B746E";
        var value = ko.utils.unwrapObservable(valueAccessor());

        var options = allBindingsAccessor().controlOptions;
        var validationType = options.validateType;

        if (options != undefined) {
            if (validationType == 'required') {
                if (!isEmpty(value)) {
                    setControlIndicatorOk(element);
                }
                else {
                    setControlIndicatorInfo(element);
                }
            }

            if (validationType == "number") {
                if (isNumber(value)) {
                    setControlIndicatorOk(element);
                }
                else {
                    setControlIndicatorInfo(element);
                }
            }

            if (validationType == "float") {
                if (isFloat(value)) {
                    setControlIndicatorOk(element);
                }
                else {
                    setControlIndicatorInfo(element);
                }
            }

            if (validationType == "int") {
                if (isInteger(value)) {
                    setControlIndicatorOk(element);
                }
                else {
                    setControlIndicatorInfo(element);
                }
            }
        }

        function updateViewModelErrorState(status) {
            if (viewModel.errorInForm != undefined) {
                viewModel.errorInForm(status);
            }
        }

        function isNumber(n) {
            return !isNaN(parseFloat(n)) && isFinite(n);
        }

        function isFloat(n) {
            return n === +n && n !== (n | 0);
        }

        function isInteger(n) {
            return n === +n && n === (n | 0);
        }

        function isEmpty(str) {
            return (!str || 0 === str.length);
        }

        function isBlank(str) {
            return (!str || /^\s*$/.test(str));
        }

        function setControlIndicatorOk(element, validationStatus) {
            $(element).parent().prev().children("i").css('color', okColorDefinition);
        }

        function setControlIndicatorInfo(element, validationStatus) {
            $(element).parent().prev().children("i").css('color', attentionGrabbingColorDefinition);

        }
    }
};
