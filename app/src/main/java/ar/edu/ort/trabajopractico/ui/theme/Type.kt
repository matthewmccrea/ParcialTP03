package ar.edu.ort.trabajopractico.ui.theme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import ar.edu.ort.trabajopractico.R



val fontName = GoogleFont("Poppins")


val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontFamilyPoppins = FontFamily(
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Light),
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.SemiBold),
            Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Bold)

)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

)
val buttonLarge = TextStyle(
    fontFamily = fontFamilyPoppins,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 28.8.sp,
    letterSpacing = 0.sp
)

object AppTypography {
    val sectionTitle = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 28.8.sp,
        letterSpacing = 0.sp
    )

    val settingsItem = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp
    )

    val privacyItem = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Normal,
        color = Color(0xFFB3B1B0),
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp
    )

    val buttonLarge = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 28.8.sp,
        letterSpacing = 0.sp
    )

    val tabSelected = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 19.2.sp,
        letterSpacing = 0.sp,
        color = Color.White
    )

    val tabUnselected = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 19.2.sp,
        letterSpacing = 0.sp,
        color = Color(0xFF9E9E9E)
    )

    val profileName = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 30.sp, // 150% de 20
        letterSpacing = 0.sp,
        color = Color.Black
    )

    val statsNumber = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 28.8.sp, // 160% de 18
        letterSpacing = 0.sp,
        color = Color.Black
    )

    val statsName = TextStyle(
        fontFamily = fontFamilyPoppins,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 19.2.sp, // 160% de 12
        letterSpacing = 0.sp,
        color = Color.Gray
    )
}