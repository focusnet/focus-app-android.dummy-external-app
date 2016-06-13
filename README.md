# Description

A simple external app for testing interaction with the FOCUS Mobile app

# Application Content Description

FOCUS Mobile defines its content in a JSON structure. The following excerpt corresponds 
to the inclusion of the present dummy application. This is a widget definition:

````
{
	"guid": "widget-1",
	"type": "#/definitions/widget/collect/external-app",
	"field": "field-1",
	"title": "A title",
	"config": {
		"app-identifier": "eu.focusnet.app.dummy_external_app.DummyAction", // as defined in the external app Manifest
		"launcher-button-label": "Launch my app",
		"input-object": "<ctx/reference-123/url>" // Any FocusSample to be passed as input parameter
	}
}
````

# License

````
The MIT License (MIT)
Copyright (c) 2015 Berner Fachhochschule (BFH) - www.bfh.ch

Permission is hereby granted, free of charge, to any person obtaining a copy of this software
and associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or
substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
````