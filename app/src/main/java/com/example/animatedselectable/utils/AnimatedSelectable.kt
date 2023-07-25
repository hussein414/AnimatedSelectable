package com.example.animatedselectable.utils

import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import android.service.autofill.OnClickAction
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.animatedselectable.ui.theme.Pink100
import com.example.animatedselectable.ui.theme.Pink40

@Composable
fun AnimatedSelectable(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    titleColor: Color = if (selected) Pink100 else Pink40.copy(alpha = 0.2f),
    titleSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    titleWeight: FontWeight = FontWeight.Medium,
    subtitle: String? = null,
    subtitleColor: Color = if (selected) Pink40 else Pink40.copy(alpha = 0.2f),
    borderWith: Dp = 1.dp,
    borderShader: Shape = RoundedCornerShape(10.dp),
    borderColor: Color = if (selected) Pink40 else Pink40.copy(alpha = 0.2f),
    icon: ImageVector = Icons.Default.CheckCircle,
    iconColor: Color = if (selected) Pink100 else Pink40.copy(alpha = 0.2f),
    onClick: () -> Unit
) {
    Column(modifier = modifier
        .border(width = borderWith, color = borderColor, shape = borderShader)
        .clickable {
            onClick()
        }
        .clip(borderShader)
    ) {
        Row(
            modifier = Modifier.padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(8f), text = title, style = TextStyle(
                    color = titleColor, fontSize = titleSize, fontWeight = titleWeight
                ), maxLines = 1, overflow = TextOverflow.Ellipsis
            )
            IconButton(modifier = Modifier.weight(2f), onClick = onClick) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Selectable item icon",
                    tint = iconColor
                )
            }
        }
        if (subtitle != null) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
                text = subtitle,
                style = TextStyle(color = subtitleColor),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}