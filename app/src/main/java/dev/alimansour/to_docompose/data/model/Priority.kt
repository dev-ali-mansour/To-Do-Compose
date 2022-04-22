package dev.alimansour.to_docompose.data.model

import androidx.compose.ui.graphics.Color
import dev.alimansour.to_docompose.ui.theme.HighPriorityColor
import dev.alimansour.to_docompose.ui.theme.LowPriorityColor
import dev.alimansour.to_docompose.ui.theme.MediumPriorityColor
import dev.alimansour.to_docompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}