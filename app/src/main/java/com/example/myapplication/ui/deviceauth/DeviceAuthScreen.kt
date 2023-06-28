package com.example.myapplication.ui.deviceauth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.ui.sections.FooterModelSection
import com.example.myapplication.ui.sections.HeaderModelSection

@Composable
fun DeviceAuthScreen(
    onClick: () -> Unit,
) {
    val myScreenViewModel = hiltViewModel<DeviceAuthViewModel>()
    val uiState = myScreenViewModel.uiState

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (header, body, footer) = createRefs()

        HeaderModelSection(
            title = uiState.deviceAuthScreenModel?.headerModel?.title ?: "Default title",
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        FooterModelSection(
            leftButtonModel = uiState.deviceAuthScreenModel?.footerModel?.leftButtonModel,
            rightButtonModel = uiState.deviceAuthScreenModel?.footerModel?.rightButtonModel,
            modifier = Modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onClick = { onClick.invoke() }
        )

        /*BodySection(
            body = uiState.deviceAuthScreenModel?.body,
            modifier = Modifier.constrainAs(body) {
                top.linkTo(header.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(footer.top)
            }
        )

        FooterSection(
            buttonList = uiState.deviceAuthScreenModel?.footer?.buttonList,
            modifier = Modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onClick = { onClick.invoke() }
        )*/
    }
}
