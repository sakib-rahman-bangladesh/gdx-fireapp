/*
 * Copyright 2018 mk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mk.gdx.firebase.android.utils;

import android.content.res.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import mk.gdx.firebase.android.AndroidContextTest;

public class StringResourceTest extends AndroidContextTest {

    @Test
    public void getStringResourceByName() {
        // Given
        Resources resources = Mockito.mock(Resources.class);
        String name = "test";
        Mockito.when(((AndroidApplication) Gdx.app).getResources()).thenReturn(resources);
        Mockito.when(resources.getString(Mockito.anyInt())).thenReturn("test_return");

        // When
        String result = StringResource.getStringResourceByName(name);

        // Then
        Assert.assertEquals("test_return", result);
    }
}