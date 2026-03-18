package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object AppColors {
    val HeaderTop        = Color(0xFF8D8D8D)   // abu medium atas
    val HeaderBottom     = Color(0xFF5A5A5A)   // abu gelap bawah

    val Background       = Color(0xFFF5F5F5)
    val Surface          = Color(0xFFFFFFFF)
    val SurfaceDim       = Color(0xFFEEEEEE)

    val TextPrimary      = Color(0xFF212121)
    val TextSecondary    = Color(0xFF757575)
    val TextOnDark       = Color(0xFFFFFFFF)
    val TextOnDarkMuted  = Color(0xFFE0E0E0)

    val IconEmail        = Color(0xFF4CAF50)
    val IconPhone        = Color(0xFF2196F3)
    val IconLocation     = Color(0xFFFF5722)
    val IconWebsite      = Color(0xFF9C27B0)
    val IconSkill        = Color(0xFFFF6584)

    val BtnActive        = Color(0xFF616161)   // abu saat following
    val BtnDefault       = Color(0xFF757575)   // abu normal

    val DividerColor     = Color(0xFFEEEEEE)
}

data class ProfileData(
    val name: String,
    val title: String,
    val bio: String,
    val email: String,
    val phone: String,
    val location: String,
    val website: String
)

data class SkillInfo(
    val icon: ImageVector,
    val label: String,
    val value: String
)

@Composable
fun ProfileHeader(
    name: String,
    title: String,
    bio: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(AppColors.HeaderTop, AppColors.HeaderBottom)
                )
            )
            .padding(bottom = 36.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 44.dp, start = 24.dp, end = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(110.dp)
                    .border(3.dp, Color.White.copy(alpha = 0.8f), CircleShape)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(102.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.2f))
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Foto Profil",
                        modifier = Modifier.size(58.dp),
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = AppColors.TextOnDark,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White.copy(alpha = 0.18f))
                    .padding(horizontal = 16.dp, vertical = 5.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 12.sp,
                    color = AppColors.TextOnDarkMuted,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .width(36.dp)
                    .height(1.dp)
                    .background(Color.White.copy(alpha = 0.4f))
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = bio,
                fontSize = 13.sp,
                color = AppColors.TextOnDarkMuted,
                textAlign = TextAlign.Center,
                lineHeight = 21.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
fun StatItem(
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = AppColors.TextPrimary
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            color = AppColors.TextSecondary
        )
    }
}

@Composable
fun InfoItem(
    icon: ImageVector,
    label: String,
    value: String,
    iconTint: Color = AppColors.IconEmail,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(iconTint.copy(alpha = 0.12f))
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = iconTint,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                fontSize = 11.sp,
                color = AppColors.TextSecondary,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.5.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                fontSize = 14.sp,
                color = AppColors.TextPrimary,
                fontWeight = FontWeight.SemiBold
            )
        }

        Icon(
            imageVector = Icons.Filled.ChevronRight,
            contentDescription = null,
            tint = AppColors.DividerColor,
            modifier = Modifier.size(16.dp)
        )
    }

    Divider(
        color = AppColors.DividerColor,
        thickness = 0.5.dp,
        modifier = Modifier.padding(start = 54.dp)
    )
}

@Composable
fun ProfileCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = AppColors.Surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Text(
                text = title.uppercase(),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = AppColors.BtnActive,
                letterSpacing = 1.5.sp,
                modifier = Modifier.padding(bottom = 8.dp, start = 4.dp)
            )
            content()
        }
    }
}

@Composable
fun ProfileScreen() {
    val profile = ProfileData(
        name = "Pradana Figo Ariasya ",
        title = "Mahasiswa Teknik Informatika",
        bio = "Saya adalah mahasiswa yang sedang menempuh pendidikan di Institut Teknologi Sumatera (ITERA) pada program studi Informatika. Sebagai mahasiswa, saya aktif mengikuti kegiatan perkuliahan serta mempelajari berbagai bidang ilmu yang berkaitan dengan teknologi dan pengembangan sistem informasi.",
        email = "pradana.123140063@student.itera.ac.id",
        phone = "+62 853-8312-2030",
        location = "Bandar Lamapung, Indonesia",
        website = "github.com/PradanaFigo"
    )

    var isFollowing by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    val skills = listOf(
        SkillInfo(Icons.Filled.Code,           "Mobile Development", "Kotlin, Compose"),
        SkillInfo(Icons.Filled.Storage,        "Data Management",    "MySQL, MongoDB"),
        SkillInfo(Icons.Filled.DesignServices, "Web Development",    "HTML, CSS, JavaScript")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .verticalScroll(scrollState)
    ) {
        ProfileHeader(
            name  = profile.name,
            title = profile.title,
            bio   = profile.bio
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .offset(y = (-20).dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = AppColors.Surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem(value = "12",   label = "Proyek")
                Divider(
                    modifier = Modifier.height(36.dp).width(1.dp),
                    color = AppColors.DividerColor
                )
                StatItem(value = "4.00", label = "IPK")
                Divider(
                    modifier = Modifier.height(36.dp).width(1.dp),
                    color = AppColors.DividerColor
                )
                StatItem(value = "6",    label = "Semester")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Button(
                onClick = { isFollowing = !isFollowing },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isFollowing) AppColors.BtnActive
                    else AppColors.BtnDefault
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Icon(
                    imageVector = if (isFollowing) Icons.Filled.Check
                    else Icons.Filled.PersonAdd,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isFollowing) "Following" else "Follow",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        ProfileCard(title = "Informasi Kontak") {
            InfoItem(
                icon     = Icons.Filled.Email,
                label    = "Email",
                value    = profile.email,
                iconTint = AppColors.IconEmail
            )
            InfoItem(
                icon     = Icons.Filled.Phone,
                label    = "Telepon",
                value    = profile.phone,
                iconTint = AppColors.IconPhone
            )
            InfoItem(
                icon     = Icons.Filled.LocationOn,
                label    = "Lokasi",
                value    = profile.location,
                iconTint = AppColors.IconLocation
            )
            InfoItem(
                icon     = Icons.Filled.Language,
                label    = "Website / GitHub",
                value    = profile.website,
                iconTint = AppColors.IconWebsite
            )
        }

        ProfileCard(title = "Keahlian") {
            skills.forEach { skill ->
                InfoItem(
                    icon     = skill.icon,
                    label    = skill.label,
                    value    = skill.value,
                    iconTint = AppColors.IconSkill
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}