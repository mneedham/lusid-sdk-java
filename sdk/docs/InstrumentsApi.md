# InstrumentsApi

All URIs are relative to *https://fbn-prd.lusid.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteInstrument**](InstrumentsApi.md#deleteInstrument) | **DELETE** /api/instruments/{identifierType}/{identifier} | [EARLY ACCESS] Delete instrument
[**getInstrument**](InstrumentsApi.md#getInstrument) | **GET** /api/instruments/{identifierType}/{identifier} | Get instrument
[**getInstrumentIdentifierTypes**](InstrumentsApi.md#getInstrumentIdentifierTypes) | **GET** /api/instruments/identifierTypes | [EARLY ACCESS] Get instrument identifier types
[**getInstrumentPropertyTimeSeries**](InstrumentsApi.md#getInstrumentPropertyTimeSeries) | **GET** /api/instruments/{identifierType}/{identifier}/properties/time-series | [EARLY ACCESS] Get the time series of an instrument property
[**getInstruments**](InstrumentsApi.md#getInstruments) | **POST** /api/instruments/$get | Get instruments
[**listInstruments**](InstrumentsApi.md#listInstruments) | **GET** /api/instruments | [EARLY ACCESS] List instruments
[**updateInstrumentIdentifier**](InstrumentsApi.md#updateInstrumentIdentifier) | **POST** /api/instruments/{identifierType}/{identifier} | [EARLY ACCESS] Update instrument identifier
[**upsertInstruments**](InstrumentsApi.md#upsertInstruments) | **POST** /api/instruments | Upsert instruments
[**upsertInstrumentsProperties**](InstrumentsApi.md#upsertInstrumentsProperties) | **POST** /api/instruments/$upsertproperties | Upsert instruments properties


<a name="deleteInstrument"></a>
# **deleteInstrument**
> DeleteInstrumentResponse deleteInstrument(identifierType, identifier)

[EARLY ACCESS] Delete instrument

Delete a single instrument identified by a unique instrument identifier. Once an instrument has been  deleted it will be marked as &#39;inactive&#39; and it can no longer be used when updating or inserting transactions or holdings.  You can still query existing transactions and holdings related to the deleted instrument.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.InstrumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    InstrumentsApi apiInstance = new InstrumentsApi(defaultClient);
    String identifierType = "identifierType_example"; // String | The identifier being supplied e.g. \"Figi\".
    String identifier = "identifier_example"; // String | The value of the identifier that resolves to the instrument to delete.
    try {
      DeleteInstrumentResponse result = apiInstance.deleteInstrument(identifierType, identifier);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstrumentsApi#deleteInstrument");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifierType** | **String**| The identifier being supplied e.g. \&quot;Figi\&quot;. |
 **identifier** | **String**| The value of the identifier that resolves to the instrument to delete. |

### Return type

[**DeleteInstrumentResponse**](DeleteInstrumentResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The datetime that the instrument was deleted |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getInstrument"></a>
# **getInstrument**
> Instrument getInstrument(identifierType, identifier, effectiveAt, asAt, propertyKeys)

Get instrument

Get the definition of a single instrument identified by a unique instrument identifier.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.InstrumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    InstrumentsApi apiInstance = new InstrumentsApi(defaultClient);
    String identifierType = "identifierType_example"; // String | The identifier being supplied e.g. \"Figi\".
    String identifier = "identifier_example"; // String | The value of the identifier for the requested instrument.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve the instrument definition.              Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the instrument definition. Defaults to              return the latest version of the instrument definition if not specified.
    List<String> propertyKeys = Arrays.asList(); // List<String> | A list of property keys from the \"Instrument\" domain to decorate onto the instrument.              These take the format {domain}/{scope}/{code} e.g. \"Instrument/system/Name\".
    try {
      Instrument result = apiInstance.getInstrument(identifierType, identifier, effectiveAt, asAt, propertyKeys);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstrumentsApi#getInstrument");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifierType** | **String**| The identifier being supplied e.g. \&quot;Figi\&quot;. |
 **identifier** | **String**| The value of the identifier for the requested instrument. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve the instrument definition.              Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the instrument definition. Defaults to              return the latest version of the instrument definition if not specified. | [optional]
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the \&quot;Instrument\&quot; domain to decorate onto the instrument.              These take the format {domain}/{scope}/{code} e.g. \&quot;Instrument/system/Name\&quot;. | [optional]

### Return type

[**Instrument**](Instrument.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested instrument |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getInstrumentIdentifierTypes"></a>
# **getInstrumentIdentifierTypes**
> ResourceListOfInstrumentIdTypeDescriptor getInstrumentIdentifierTypes()

[EARLY ACCESS] Get instrument identifier types

Get the allowable instrument identifier types and their descriptions.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.InstrumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    InstrumentsApi apiInstance = new InstrumentsApi(defaultClient);
    try {
      ResourceListOfInstrumentIdTypeDescriptor result = apiInstance.getInstrumentIdentifierTypes();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstrumentsApi#getInstrumentIdentifierTypes");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ResourceListOfInstrumentIdTypeDescriptor**](ResourceListOfInstrumentIdTypeDescriptor.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The allowable instrument identifier types |  -  |
**0** | Error response |  -  |

<a name="getInstrumentPropertyTimeSeries"></a>
# **getInstrumentPropertyTimeSeries**
> ResourceListOfPropertyInterval getInstrumentPropertyTimeSeries(identifierType, identifier, propertyKey, identifierEffectiveAt, asAt, filter, page, limit)

[EARLY ACCESS] Get the time series of an instrument property

List the complete time series of an instrument property.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.InstrumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    InstrumentsApi apiInstance = new InstrumentsApi(defaultClient);
    String identifierType = "identifierType_example"; // String | The identifier type of the instrument, e.g., \"Figi\"
    String identifier = "identifier_example"; // String | The value of the identifier for the requested instrument.
    String propertyKey = "propertyKey_example"; // String | The property key of the property that will have its history shown. These must be in the format {domain}/{scope}/{code} e.g. \"Instrument/system/Name\".              Each property must be from the \"Instrument\" domain.
    String identifierEffectiveAt = "identifierEffectiveAt_example"; // String | The effective datetime used to resolve the instrument from the provided identifier. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to list the instrument's property history. Defaults to return the current datetime if not supplied.
    String filter = "filter_example"; // String | Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    String page = "page_example"; // String | The pagination token to use to continue listing properties from a previous call to get property time series.              This value is returned from the previous call. If a pagination token is provided the filter, effectiveAt, and asAt fields              must not have changed since the original request.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many.
    try {
      ResourceListOfPropertyInterval result = apiInstance.getInstrumentPropertyTimeSeries(identifierType, identifier, propertyKey, identifierEffectiveAt, asAt, filter, page, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstrumentsApi#getInstrumentPropertyTimeSeries");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifierType** | **String**| The identifier type of the instrument, e.g., \&quot;Figi\&quot; |
 **identifier** | **String**| The value of the identifier for the requested instrument. |
 **propertyKey** | **String**| The property key of the property that will have its history shown. These must be in the format {domain}/{scope}/{code} e.g. \&quot;Instrument/system/Name\&quot;.              Each property must be from the \&quot;Instrument\&quot; domain. | [optional]
 **identifierEffectiveAt** | **String**| The effective datetime used to resolve the instrument from the provided identifier. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to list the instrument&#39;s property history. Defaults to return the current datetime if not supplied. | [optional]
 **filter** | **String**| Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]
 **page** | **String**| The pagination token to use to continue listing properties from a previous call to get property time series.              This value is returned from the previous call. If a pagination token is provided the filter, effectiveAt, and asAt fields              must not have changed since the original request. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. | [optional]

### Return type

[**ResourceListOfPropertyInterval**](ResourceListOfPropertyInterval.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The time series of the property |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getInstruments"></a>
# **getInstruments**
> GetInstrumentsResponse getInstruments(identifierType, requestBody, effectiveAt, asAt, propertyKeys)

Get instruments

Get the definition of one or more instruments identified by a collection of unique instrument identifiers.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.InstrumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    InstrumentsApi apiInstance = new InstrumentsApi(defaultClient);
    String identifierType = "identifierType_example"; // String | The identifier being supplied e.g. \"Figi\".
    List<String> requestBody = ["instrument-identifier-1","instrument-identifier-2"]; // List<String> | The values of the identifier for the requested instruments.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve the instrument definitions.              Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the instrument definitions.              Defaults to return the latest version of each instrument definition if not specified.
    List<String> propertyKeys = Arrays.asList(); // List<String> | A list of property keys from the \"Instrument\" domain to decorate onto the instrument.              These take the format {domain}/{scope}/{code} e.g. \"Instrument/system/Name\".
    try {
      GetInstrumentsResponse result = apiInstance.getInstruments(identifierType, requestBody, effectiveAt, asAt, propertyKeys);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstrumentsApi#getInstruments");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifierType** | **String**| The identifier being supplied e.g. \&quot;Figi\&quot;. |
 **requestBody** | [**List&lt;String&gt;**](String.md)| The values of the identifier for the requested instruments. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve the instrument definitions.              Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the instrument definitions.              Defaults to return the latest version of each instrument definition if not specified. | [optional]
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the \&quot;Instrument\&quot; domain to decorate onto the instrument.              These take the format {domain}/{scope}/{code} e.g. \&quot;Instrument/system/Name\&quot;. | [optional]

### Return type

[**GetInstrumentsResponse**](GetInstrumentsResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested instruments which could be identified along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listInstruments"></a>
# **listInstruments**
> PagedResourceListOfInstrument listInstruments(asAt, effectiveAt, page, sortBy, start, limit, filter, instrumentPropertyKeys)

[EARLY ACCESS] List instruments

List all the instruments that have been mastered in the LUSID instrument master.  The maximum number of instruments that this method can list per request is 2,000.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.InstrumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    InstrumentsApi apiInstance = new InstrumentsApi(defaultClient);
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to list the instruments. Defaults to return the latest              version of each instruments if not specified.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to list the instruments.              Defaults to the current LUSID system datetime if not specified.
    String page = "page_example"; // String | The pagination token to use to continue listing instruments from a previous call to list instruments.              This value is returned from the previous call. If a pagination token is provided the sortBy, filter, effectiveAt, and asAt fields              must not have changed since the original request. Also, if set, a start value cannot be provided.
    List<String> sortBy = Arrays.asList(); // List<String> | Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName.
    Integer start = 56; // Integer | When paginating, skip this number of results.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many.
    String filter = "\"State eq 'Active'\""; // String | Expression to filter the result set. Defaults to filter down to active instruments only, i.e. those              that have not been deleted. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    List<String> instrumentPropertyKeys = Arrays.asList(); // List<String> | A list of property keys from the \"Instrument\" domain to decorate onto each instrument. These take the format {domain}/{scope}/{code} e.g. \"Instrument/system/Name\".
    try {
      PagedResourceListOfInstrument result = apiInstance.listInstruments(asAt, effectiveAt, page, sortBy, start, limit, filter, instrumentPropertyKeys);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstrumentsApi#listInstruments");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asAt** | **OffsetDateTime**| The asAt datetime at which to list the instruments. Defaults to return the latest              version of each instruments if not specified. | [optional]
 **effectiveAt** | **String**| The effective datetime or cut label at which to list the instruments.              Defaults to the current LUSID system datetime if not specified. | [optional]
 **page** | **String**| The pagination token to use to continue listing instruments from a previous call to list instruments.              This value is returned from the previous call. If a pagination token is provided the sortBy, filter, effectiveAt, and asAt fields              must not have changed since the original request. Also, if set, a start value cannot be provided. | [optional]
 **sortBy** | [**List&lt;String&gt;**](String.md)| Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName. | [optional]
 **start** | **Integer**| When paginating, skip this number of results. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. | [optional]
 **filter** | **String**| Expression to filter the result set. Defaults to filter down to active instruments only, i.e. those              that have not been deleted. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional] [default to &quot;State eq &#39;Active&#39;&quot;]
 **instrumentPropertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the \&quot;Instrument\&quot; domain to decorate onto each instrument. These take the format {domain}/{scope}/{code} e.g. \&quot;Instrument/system/Name\&quot;. | [optional]

### Return type

[**PagedResourceListOfInstrument**](PagedResourceListOfInstrument.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested instruments |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="updateInstrumentIdentifier"></a>
# **updateInstrumentIdentifier**
> Instrument updateInstrumentIdentifier(identifierType, identifier, updateInstrumentIdentifierRequest)

[EARLY ACCESS] Update instrument identifier

Update, insert or delete a single instrument identifier for a single instrument. If it is not being deleted  the identifier will be updated if it already exists and inserted if it does not.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.InstrumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    InstrumentsApi apiInstance = new InstrumentsApi(defaultClient);
    String identifierType = "identifierType_example"; // String | The identifier to use to resolve the instrument e.g. \"Figi\".
    String identifier = "identifier_example"; // String | The original value of the identifier for the requested instrument.
    UpdateInstrumentIdentifierRequest updateInstrumentIdentifierRequest = {"type":"Figi","value":"updated-figi","effectiveAt":"2018-02-01T10:00:00.0000000+00:00"}; // UpdateInstrumentIdentifierRequest | The identifier to update or remove. This may or may not be the same identifier used              to resolve the instrument.
    try {
      Instrument result = apiInstance.updateInstrumentIdentifier(identifierType, identifier, updateInstrumentIdentifierRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstrumentsApi#updateInstrumentIdentifier");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifierType** | **String**| The identifier to use to resolve the instrument e.g. \&quot;Figi\&quot;. |
 **identifier** | **String**| The original value of the identifier for the requested instrument. |
 **updateInstrumentIdentifierRequest** | [**UpdateInstrumentIdentifierRequest**](UpdateInstrumentIdentifierRequest.md)| The identifier to update or remove. This may or may not be the same identifier used              to resolve the instrument. |

### Return type

[**Instrument**](Instrument.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated instrument definition with the identifier updated, inserted or deleted |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertInstruments"></a>
# **upsertInstruments**
> UpsertInstrumentsResponse upsertInstruments(requestBody)

Upsert instruments

Update or insert one or more instruments into the LUSID instrument master. An instrument will be updated  if it already exists and inserted if it does not.                In the request each instrument definition should be keyed by a unique correlation id. This id is ephemeral  and is not stored by LUSID. It serves only as a way to easily identify each instrument in the response.                The response will return both the collection of successfully updated or inserted instruments, as well as those that failed.  For the failures a reason will be provided explaining why the instrument could not be updated or inserted.                It is important to always check the failed set for any unsuccessful results.  The maximum number of instruments that this method can upsert per request is 2,000.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.InstrumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    InstrumentsApi apiInstance = new InstrumentsApi(defaultClient);
    Map<String, InstrumentDefinition> requestBody = {"request_id_1":{"name":"Instrument name","identifiers":{"clientInternal":{"value":"some-identifier","effectiveAt":"0001-01-01T00:00:00.0000000+00:00"},"figi":{"value":"some-figi-code","effectiveAt":"0001-01-01T00:00:00.0000000+00:00"},"isin":{"value":"some-isin-code","effectiveAt":"0001-01-01T00:00:00.0000000+00:00"}},"properties":[{"key":"Instrument/someScope/somePropertyName","value":{"labelValue":"some-property-value"},"effectiveFrom":"2018-06-18T09:00:00.0000000+00:00"}],"lookThroughPortfolioId":{"scope":"MyScope","code":"portfolio-code"},"definition":{"instrumentFormat":{"sourceSystem":"systemA","vendor":"Unknown","version":"1.0.0"},"content":"{\"some-key\": \"some-value\"}","instrumentType":"ExoticInstrument"}},"request_id_2":{"name":"Instrument name","identifiers":{"clientInternal":{"value":"some-identifier-2","effectiveAt":"0001-01-01T00:00:00.0000000+00:00"},"figi":{"value":"some-figi-code-2","effectiveAt":"0001-01-01T00:00:00.0000000+00:00"}},"properties":[],"lookThroughPortfolioId":{"scope":"MyScope","code":"portfolio-code"},"definition":{"instrumentFormat":{"sourceSystem":"systemA","vendor":"Unknown","version":"1.0.0"},"content":"{\"some-key\": \"some-value\"}","instrumentType":"ExoticInstrument"}}}; // Map<String, InstrumentDefinition> | The definitions of the instruments to update or insert.
    try {
      UpsertInstrumentsResponse result = apiInstance.upsertInstruments(requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstrumentsApi#upsertInstruments");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestBody** | [**Map&lt;String, InstrumentDefinition&gt;**](InstrumentDefinition.md)| The definitions of the instruments to update or insert. |

### Return type

[**UpsertInstrumentsResponse**](UpsertInstrumentsResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | The successfully updated or inserted instruments along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertInstrumentsProperties"></a>
# **upsertInstrumentsProperties**
> UpsertInstrumentPropertiesResponse upsertInstrumentsProperties(upsertInstrumentPropertyRequest)

Upsert instruments properties

Update or insert one or more instrument properties for one or more instruments. Each instrument property will be updated  if it already exists and inserted if it does not. If any properties fail to be updated or inserted, none will be updated or inserted and  the reason for the failure will be returned.                Properties have an &lt;i&gt;effectiveFrom&lt;/i&gt; datetime for which the property is valid, and an &lt;i&gt;effectiveUntil&lt;/i&gt;  datetime until which the property is valid. Not supplying an &lt;i&gt;effectiveUntil&lt;/i&gt; datetime results in the property being  valid indefinitely, or until the next &lt;i&gt;effectiveFrom&lt;/i&gt; datetime of the property.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.InstrumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    InstrumentsApi apiInstance = new InstrumentsApi(defaultClient);
    List<UpsertInstrumentPropertyRequest> upsertInstrumentPropertyRequest = [{"identifierType":"LusidInstrumentId","identifier":"LUID_00000000","properties":[{"key":"Instrument/MyScope/SomePropertyName","value":{"labelValue":"SomeValue1"},"effectiveFrom":"2016-09-15T12:00:00.0000000+00:00"},{"key":"Instrument/MyScope/SomePropertyName","value":{"labelValue":"SomeValue2"},"effectiveFrom":"2017-08-10T12:00:00.0000000+00:00"},{"key":"Instrument/MyScope/AnotherPropertyName","value":{"labelValue":"AnotherValue1"},"effectiveFrom":"2018-03-05T12:00:00.0000000+00:00","effectiveUntil":"2019-06-01T12:00:00.0000000+00:00"},{"key":"Instrument/MyScope/AnotherPropertyName","value":{"labelValue":"AnotherValue2"},"effectiveFrom":"2020-03-15T12:00:00.0000000+00:00","effectiveUntil":"2021-01-15T12:00:00.0000000+00:00"}]}]; // List<UpsertInstrumentPropertyRequest> | A collection of instruments and associated instrument properties to update or insert.
    try {
      UpsertInstrumentPropertiesResponse result = apiInstance.upsertInstrumentsProperties(upsertInstrumentPropertyRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstrumentsApi#upsertInstrumentsProperties");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **upsertInstrumentPropertyRequest** | [**List&lt;UpsertInstrumentPropertyRequest&gt;**](UpsertInstrumentPropertyRequest.md)| A collection of instruments and associated instrument properties to update or insert. |

### Return type

[**UpsertInstrumentPropertiesResponse**](UpsertInstrumentPropertiesResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | The asAt time at which the properties were updated, inserted or deleted |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

