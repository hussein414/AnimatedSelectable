# AnimatedSelectable
Animated Selectable Item with Jetpack Compose | Android Studio Tutorial

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
