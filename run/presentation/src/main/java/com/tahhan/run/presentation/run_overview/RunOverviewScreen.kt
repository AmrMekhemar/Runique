@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.tahhan.run.presentation.run_overview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tahhan.core.presentation.designsystem.AnalyticsIcon
import com.tahhan.core.presentation.designsystem.LogoIcon
import com.tahhan.core.presentation.designsystem.LogoutIcon
import com.tahhan.core.presentation.designsystem.RunIcon
import com.tahhan.core.presentation.designsystem.RuniqueTheme
import com.tahhan.core.presentation.designsystem.components.RuniqueFloatingActionButton
import com.tahhan.core.presentation.designsystem.components.RuniqueScaffold
import com.tahhan.core.presentation.designsystem.components.RuniqueToolbar
import com.tahhan.core.presentation.designsystem.components.util.DropDownItem
import com.tahhan.run.presentation.R
import com.tahhan.run.presentation.run_overview.components.RunListItem
import org.koin.androidx.compose.koinViewModel

@Composable

fun RunOverviewScreenRoot(
    onStartRunClick: () -> Unit,
    onLogoutClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel()
) {

    RunOverviewScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                RunOverviewAction.OnStartClick -> onStartRunClick()
                RunOverviewAction.OnLogoutClick -> onLogoutClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )

}

@Composable

private fun RunOverviewScreen(
    state: RunOverviewState,
    onAction: (RunOverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    RuniqueScaffold(topAppBar = {
        RuniqueToolbar(showBackButton = false,
            title = stringResource(R.string.Runique),
            scrollBehavior = scrollBehavior,
            menuItems = listOf(
                DropDownItem(
                    icon = AnalyticsIcon, title = stringResource(R.string.analytics)
                ),
                DropDownItem(
                    icon = LogoutIcon, title = stringResource(R.string.logout)
                ),
            ),
            onMenuItemClick = { index ->
                when (index) {
                    0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                    1 -> onAction(RunOverviewAction.OnLogoutClick)
                }
            },
            startContent = {
                Icon(
                    imageVector = LogoIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(30.dp)
                )
            })
    }, floatingActionButton = {
        RuniqueFloatingActionButton(icon = RunIcon, onClick = {
            onAction(RunOverviewAction.OnStartClick)
        })
    }) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .padding(horizontal = 16.dp),
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = state.runs,
                key = {it.id}
            ) {
                RunListItem(
                    runUi = it,
                    onDeleteClick = {
                        onAction(RunOverviewAction.DeleteRun(it))
                    },
                    modifier = Modifier
                        .animateItemPlacement()
                )
            }
        }
    }
}

@Preview
@Composable
private fun RunOverviewActionRootScreenPreview() {
    RuniqueTheme {
        RunOverviewScreen(
            state = RunOverviewState(),
            onAction = {}
        )
    }
}