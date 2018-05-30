/**
 * Copyright © 2018 FINBOURNE TECHNOLOGY LTD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package com.finbourne.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The KeyValuePairCodeTypeString model.
 */
public class KeyValuePairCodeTypeString {
    /**
     * Possible values include: 'Undefined', 'ReutersAssetId', 'CINS', 'Isin',
     * 'Sedol', 'Cusip', 'ClientInternal', 'Figi', 'Wertpapier'.
     */
    @JsonProperty(value = "key", access = JsonProperty.Access.WRITE_ONLY)
    private String key;

    /**
     * The value property.
     */
    @JsonProperty(value = "value", access = JsonProperty.Access.WRITE_ONLY)
    private String value;

    /**
     * Get possible values include: 'Undefined', 'ReutersAssetId', 'CINS', 'Isin', 'Sedol', 'Cusip', 'ClientInternal', 'Figi', 'Wertpapier'.
     *
     * @return the key value
     */
    public String key() {
        return this.key;
    }

    /**
     * Get the value value.
     *
     * @return the value value
     */
    public String value() {
        return this.value;
    }

}
