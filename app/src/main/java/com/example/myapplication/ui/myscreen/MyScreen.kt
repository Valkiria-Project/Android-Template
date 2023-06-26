package com.example.myapplication.ui.myscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.domain.myscreen.model.BodyRow
import com.example.myapplication.domain.myscreen.model.Button
import com.example.myapplication.domain.myscreen.model.CrossSelling
import com.example.myapplication.domain.myscreen.model.Message
import com.example.myapplication.domain.myscreen.model.Section

@Composable
fun MyScreen(
    onClick: () -> Unit
) {
    val myScreenViewModel = hiltViewModel<MyScreenViewModel>()
    val uiState = myScreenViewModel.uiState

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (type, header, body, footer) = createRefs()

        Text(
            text = uiState.myScreenModel?.type?.name.orEmpty(),
            modifier = Modifier.constrainAs(type) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        HeaderSection(
            title = uiState.myScreenModel?.header?.title ?: "Default title",
            iconUrl = uiState.myScreenModel?.header?.iconUrl,
            modifier = Modifier.constrainAs(header) {
                top.linkTo(type.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        BodySection(
            body = uiState.myScreenModel?.body,
            modifier = Modifier.constrainAs(body) {
                top.linkTo(header.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(footer.top)
            }
        )

        FooterSection(
            buttonList = uiState.myScreenModel?.footer?.buttonList,
            modifier = Modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onClick = { onClick.invoke() }
        )
    }
}

@Composable
fun HeaderSection(
    title: String,
    iconUrl: String?,
    modifier: Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
        )
        AsyncImage(
            model = iconUrl,
            contentDescription = "Header icon url",
            placeholder = painterResource(R.drawable.ic_offline),
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
fun BodySection(
    body: List<BodyRow>?,
    modifier: Modifier
) {
    if (body?.isNotEmpty() == true) {
        LazyColumn(
            modifier = modifier
        ) {
            body.map { bodyRow ->
                when (bodyRow) {
                    is CrossSelling -> item {
                        Text(
                            text = bodyRow.text
                        )
                    }

                    is Message -> item {
                        Text(
                            text = bodyRow.text
                        )
                    }

                    is Section -> item {
                        Text(
                            text = bodyRow.sectionTitle
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FooterSection(
    buttonList: List<Button>?,
    modifier: Modifier,
    onClick: () -> Unit
) {
    if (buttonList?.isNotEmpty() == true) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            buttonList.map { button ->
                Button(
                    onClick = { onClick.invoke() }
                ) {
                    Text(text = button.label)
                }
            }
        }
    }
}
