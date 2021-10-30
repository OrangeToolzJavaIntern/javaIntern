package com.example.demo.getpostapi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetPostWithThirdPartyApi {

	public static void main(String[] args) {

		Scanner inScanner = new Scanner(System.in);
		System.out.println("GET Data From 3rd Party Rest API Press 1 |Post Data With 3rd Party Rest API Press 2");
		System.out.print("You Entered: ");
		String input = inScanner.next();

		if (input.equals("1")) {
			try {
				getApiRequest();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (input.equals("2")) {

			try {
				postApiRequest();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("You Press Wrong Number or Anything Please press valid number");
		}

	}

	public static void postApiRequest() throws IOException {

		String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjZjZTdjN2Q3OTk1N2IyM2Y0ZWU1ODlhZTcxM2E2"
				+ "MGM2YmIxODQ0OWU2NjZlMzhkMWUyZWU2ODg5M2Q2Nzk3ZDQ5NzhmODc5MGQ4MWQ5Njg2In0.eyJhdWQiOiIxI"
				+ "iwianRpIjoiNmNlN2M3ZDc5OTU3YjIzZjRlZTU4OWFlNzEzYTYwYzZiYjE4NDQ5ZTY2NmUzOGQxZTJlZTY4ODkz"
				+ "ZDY3OTdkNDk3OGY4NzkwZDgxZDk2ODYiLCJpYXQiOjE2MzU0MzQwNjcsIm5iZiI6MTYzNTQzNDA2NywiZXhwIjo0N"
				+ "zkxMTA3NjY3LCJzdWIiOiIxNzcwNiIsInNjb3BlcyI6W119.rdS9SoWTE-spq8lpe4EQd6m7vtu0H-vXj2aG-7Tzl"
				+ "qAg9snsVo95Meq6B78ueFteVO2PrFCHhnaOjpS2IQ5dWKgFqUXFRGaIsx4_uH5ZnWbfgQlcp-VFbiepZcXRjh97dx_b"
				+ "Eo3AC1d8ch2k8znfmkuK8qd8LhyRnZ0a7p0ck7tHpehkPeE9Lz2qZ03yLZAlB1lNQ4DmTR63MGTJpxBBYj5KQh4PQhdUp"
				+ "SMcHEwhGgS1kaM4zeUaNeFJrVhRs9AEWeA0OKytbf0nLU1Ihb2TK-5JuT4GrBgm3uvEPY3dtEIceGfBJIYLNWqgAFbw63"
				+ "8uYGlWV6E7y-IdGzvbogBvBBiPhbFwtEEcqa_7_39n5qOmhmMs5PW48ydSGFBTa4j6"
				+ "EGcep4diHUi2DH4eQ9jsvP2J9Nm4t-lC0HWTn3RB5hBQpEcPrCAyhhomRuPO6141veUE-NyNGIUEZnA7sxqBmbW"
				+ "L7F4vVd5C23G8kMuR2s8tOUMZrXZW6esPjdIk3PtPkZkC4xPYhL6vJK2R4BpDgfcTeiZvIrFxZl9-Sxl9tHFNHW"
				+ "qBPzfhiPyqMKr6Khql1mnOPP10g7l2IXYm2ewaUGANQJEgI-a3bgNaojIGGySIZE1HaDkziG-GjVWBy-pPgpCk"
				+ "rFgkN3O-yXneyKOc4CLRsNg3HImGkLMc41eh8-4";

		// Url for making POST request
		URL postUrl = new URL("https://api.thanks.io/api/v2/mailing-lists/");

		HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();

		// Set POST as request method
		connection.setRequestMethod("POST");
		// get token
		connection.setRequestProperty("Authorization", "Bearer " + token);

		// Setting Header Parameters
		connection.setRequestProperty("Accept", "application/x-www-form-urlencoded");

		// connection.setUseCaches(false);
		connection.setDoOutput(true);

		// Adding Body section of POST request
		String params = "description=A strong Api";

		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
		wr.write(params);
		wr.close();
		connection.connect();

		// Getting Response
		int responseCode = connection.getResponseCode();

		// Checking ckode for 201 (Created)
		if (responseCode == HttpURLConnection.HTTP_CREATED) {

			StringBuffer jsonResponseData = new StringBuffer();
			String readLine = null;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while ((readLine = bufferedReader.readLine()) != null) {
				jsonResponseData.append(readLine + "\n");
			}

			bufferedReader.close();
			System.out.println(jsonResponseData.toString());

		} else {
			System.out.println(responseCode);
		}
	}

	public static void getApiRequest() throws IOException {

		// Get 10th record data
		URL getUrl = new URL("https://api.thanks.io/api/v2/handwriting-styles");

		HttpURLConnection conection = (HttpURLConnection) getUrl.openConnection();

		// Set request method
		conection.setRequestMethod("GET");

		// Getting response code
		int responseCode = conection.getResponseCode();

		// If responseCode is 200 means we get data successfully
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			StringBuffer jsonResponseData = new StringBuffer();
			String readLine = null;

			// Append response line by line
			while ((readLine = in.readLine()) != null) {
				jsonResponseData.append(readLine);
			}

			in.close();
			// Print result in string format
			System.out.println("JSON String Data " + jsonResponseData.toString());

		} else {
			System.out.println(responseCode);
		}

	}
}
