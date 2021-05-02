package com.fabirt.podcastapp.ui.podcast

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fabirt.podcastapp.R
import com.fabirt.podcastapp.domain.model.demoData
import com.fabirt.podcastapp.ui.common.BackButton
import com.fabirt.podcastapp.ui.common.EmphasisText
import com.fabirt.podcastapp.ui.common.PrimaryButton
import com.fabirt.podcastapp.util.formatMillisecondsAsDate
import com.fabirt.podcastapp.util.toDurationMinutes
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun PodcastDetailScreen(podcastId: String) {
    val scrollState = rememberScrollState()
    val podcast = demoData().results.find { it.id == podcastId }!!

    Surface {
        Column(
            modifier = Modifier
                .statusBarsPadding()
        ) {
            Row {
                BackButton()
            }

            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .navigationBarsPadding()
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ) {
                PodcastImage(
                    url = podcast.image,
                    modifier = Modifier.height(120.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    podcast.titleOriginal,
                    style = MaterialTheme.typography.h1
                )
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    podcast.podcast.publisherOriginal,
                    style = MaterialTheme.typography.body1
                )

                EmphasisText(
                    text = "${podcast.pubDateMS.formatMillisecondsAsDate("MMM dd")} • ${podcast.audioLengthSec.toDurationMinutes()}"
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    PrimaryButton(
                        text = stringResource(R.string.play),
                        height = 48.dp
                    ) {
                        // Play
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    com.fabirt.podcastapp.ui.common.IconButton(
                        imageVector = Icons.Rounded.Share,
                        contentDescription = stringResource(R.string.share)
                    ) {

                    }

                    com.fabirt.podcastapp.ui.common.IconButton(
                        imageVector = Icons.Rounded.Info,
                        contentDescription = stringResource(R.string.share)
                    ) {

                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Text("https://www.listennotes.com/e/ea09b575d07341599d8d5b71f205517b/")

                EmphasisText(text = podcast.descriptionOriginal)
            }
        }
    }
}