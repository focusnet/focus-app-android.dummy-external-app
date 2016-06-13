/**
 * The MIT License (MIT)
 * Copyright (c) 2015 Berner Fachhochschule (BFH) - www.bfh.ch
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package eu.focusnet.app.dummy_external_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Sample activity enabling external app calling by the FOCUS App
 *
 */
public class DummyAppActivity extends AppCompatActivity
{
	/**
	 * Extras to be set and read for communication with the FOCUS Mobile app
	 */
	private static final String
			FOCUS_INPUT_EXTRA = "eu.focusnet.app.extra.EXTERNAL_APP_INPUT",
			FOCUS_OUTPUT_EXTRA = "eu.focusnet.app.extra.EXTERNAL_APP_OUPUT";

	/**
	 * Instantiate the activity.
	 * <p/>
	 * We acquire the input extra (input parameter) and update the UI accordingly.
	 *
	 * @param savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		// acquire the input extra
		// this is a JSON string, that can be converted using GSON, for example.
		// This structure is always a {@code FocusSample}
		String inputExtraValue = getIntent().getStringExtra(FOCUS_INPUT_EXTRA);
		if (inputExtraValue == null) {
			inputExtraValue = "";
		}

		// set the acquire value into the UI
		TextView inputValue = (TextView) findViewById(R.id.my_input_field_value);
		inputValue.setText(inputExtraValue);
	}

	/**
	 * Do return the result of the activity.
	 * <p/>
	 * Set the result in the output extra.
	 *
	 * @param view
	 */
	public void onClick(View view)
	{
		// get the response that has been provided by the user
		EditText responseEditText = (EditText) findViewById(R.id.response);
		String response = responseEditText.getText().toString();

		// Save the response in an extra such that it can be transmitted back to the
		// FOCUS Mobile app
		Intent returnIntent = new Intent();
		// this is a JSON string, that can be constructed using GSON, for example
		// This structure is always a {@code FocusSample}
		returnIntent.putExtra(FOCUS_OUTPUT_EXTRA, response);

		// and terminate the activity, the return code must be RESULT_OK
		setResult(RESULT_OK, returnIntent);
		finish();
	}

}
