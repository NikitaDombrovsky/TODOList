package com.example.todolist.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    onQueryChange: (String) -> Unit,
    //isSearchActive: Boolean,
    //onActiveChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    //onSearch: (String) -> Unit ,
){
    var text by remember { mutableStateOf("") } // Query for SearchBar
    var active by remember { mutableStateOf(false) } // Active state for SearchBar
    var searchHistory = remember  { mutableStateListOf<String>() }

    val activeChanged: (Boolean) -> Unit = { active ->
        //searchQuery = ""
        onQueryChange("")
        //onActiveChanged(active)
    }
    SearchBar(
        modifier = modifier
            .padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 12.dp)
            .fillMaxWidth(),
        query = text,
        onQueryChange = {
            text = it
        },
        onSearch = {
            searchHistory.add(text)
            active = false
        },
        active = active,
        onActiveChange ={
            active = it
            activeChanged(true)
        }
        /* onActiveChange = activeChanged{
            active = it
        }*/
        ,
        placeholder = { Text(text = stringResource(id = R.string.searchBarText)) },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon")
        },
        trailingIcon = {
            if (active) {
                Icon(
                    modifier = Modifier.clickable {
                        if (text.isNotEmpty()) {
                            text = ""
                        } else {
                            active = false
                        }
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close icon"
                )
            }
        }
    )
    {
        searchHistory.forEach {
            if (it.isNotEmpty()) {
                Row(modifier = Modifier.padding(all = 14.dp)) {
                    Icon(imageVector = Icons.Default.Refresh,
                        contentDescription = null) //TODO Добавить кликабельность
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = it)
                }
            }
        }
        Divider()
        Text(
            modifier = Modifier
                .padding(all = 14.dp)
                .fillMaxWidth()
                .clickable {
                    searchHistory.clear()
                },
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            text = "clear all history"
        )
    }
}
/*@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    Search()
}*/
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EmbeddedSearchBar(
    onQueryChange: (String) -> Unit,
    isSearchActive: Boolean,
    onActiveChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit,
) {
    var searchQuery by rememberSaveable { mutableStateOf("") }
    // 1
    val activeChanged: (Boolean) -> Unit = { active ->
        searchQuery = ""
        onQueryChange("")
        onActiveChanged(active)
    }
    SearchBar(
        query = searchQuery,
        // 2
        onQueryChange = { query ->
            searchQuery = query
            onQueryChange(query)
        },
        // 3
        onSearch = onSearch,
        active = isSearchActive,
        onActiveChange = activeChanged,
        //
        modifier = modifier
            .padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 12.dp)
            .fillMaxWidth(),
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        },
        // 5
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        tonalElevation = 0.dp,
    ) {
        // Search suggestions or results
    }
}
