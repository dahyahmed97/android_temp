package com.example.consumeplusupgradedsample.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.consumeplusupgradedsample.R


@ExperimentalCoilApi
@ExperimentalUnitApi
@Composable
fun ExtendedTopAppBar(backClicked:()->Unit, notificationsClicked:()->Unit , imageUrl: String , name:String){
    Card(
        modifier = Modifier
            .background(color = MaterialTheme.colors.primary)
            .fillMaxWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(topStart = 0.dp ,topEnd = 0.dp,bottomEnd = 12.dp ,bottomStart = 12.dp)

    ) {
        Column(modifier = Modifier
            .background(color = MaterialTheme.colors.primary)
            .fillMaxWidth())  {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(clicked = { backClicked }, icon = Icons.Filled.ArrowBackIosNew )

                TitleText(title = "Consumer Finance")

                IconButton(clicked = { notificationsClicked }, icon = Icons.Filled.Notifications )
            }
            Row(
                modifier = Modifier.padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RoundedImage(imageUrl = imageUrl)
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.padding(start = 10.dp)

                ) {
                    Text(
                        text = "Welcome Back",
                        style = TextStyle(color = Color.White, fontSize = TextUnit(value = 18f, type = TextUnitType.Sp)),
                    )
                    Text(
                        text = name,
                        style = TextStyle(color = Color.White, fontSize = TextUnit(value = 18f, type = TextUnitType.Sp)),
                    )
                }
            }
        }
    }

}

@Composable
fun IconButton(clicked:()->Unit, icon:ImageVector){
  IconButton(onClick = clicked) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = Color.White
        )
    }
}

@ExperimentalUnitApi
@Composable
fun TitleText(title:String){
    Text(
        text = title,
        style = TextStyle(color = Color.White , fontSize = TextUnit(value = 14f, type = TextUnitType.Sp),
        fontWeight = FontWeight.Bold
        )
    )
}


@ExperimentalCoilApi
@Composable
fun RoundedImage(imageUrl:String){

    Image(
        painter= rememberImagePainter(imageUrl),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .size(68.dp)
            .clip(CircleShape)                       // clip to the circle shape
            .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
    )

}


@Composable
fun CustomButton(
    isEnabled:Boolean,
    buttonLabel:String,
    onClicked:()->Unit,
){
    OutlinedButton(
        onClick =onClicked,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0,156,155),
            contentColor = Color.White,
            disabledContentColor =Color.LightGray
        ),
        enabled = isEnabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .clipToBounds(),
    ) {
        Text(text = buttonLabel)
    }

}

@Composable
fun ToggleShowPasswordButton(clicked:()->Unit){
    IconButton(onClick = clicked) {
        Icon(
            imageVector = Icons.Filled.RemoveRedEye,
            contentDescription ="",
            tint =Color.LightGray
        )
    }
}

@Composable
fun CustomTextFiled(hintLabel:String,
                    textVal:String,
                    onValChange:(String)->Unit,
                    leadIcon:@Composable ()->Unit,
                    trailIcon:@Composable ()->Unit,
                    keyboardOptions: KeyboardOptions,
                    customVisualTransformation: VisualTransformation
){
    OutlinedTextField(
        value = textVal,
        onValueChange = onValChange,
        label = {Text(hintLabel)},
        keyboardOptions = keyboardOptions,

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(red =0,green = 156,blue = 155),
            unfocusedBorderColor = Color.LightGray,
            backgroundColor = Color(red=245,blue = 245,green = 245),
            leadingIconColor = Color.LightGray,
            trailingIconColor =Color.LightGray,
            focusedLabelColor =  Color(red =0,green = 156,blue = 155),



            ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(bottom = 20.dp)
            .clipToBounds()
            .height(60.dp),
        leadingIcon = leadIcon,
        trailingIcon = trailIcon,
        visualTransformation = customVisualTransformation
    )
}

@Composable
fun ProgressIndicator(showDialog:Boolean){
    if (showDialog) {
        Dialog(
            onDismissRequest = {  },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment= Alignment.Center,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
            ) {
                CircularProgressIndicator(
                    color = Color(R.color.primaryColor)
                )
            }
        }
    }
}

@ExperimentalUnitApi
@Composable
fun CustomAlertDialog(
    onDismiss:()->Unit,
    isDismissOnBack:Boolean,
    isDismissOnClickOutside:Boolean,
    imageId: Int?,
    positiveButtonClicked:()->Unit,
    negativeButtonClicked:()->Unit,
    dialogText:String,
    isDialogVisible:Boolean
) {
    if(isDialogVisible){
        Dialog(
            onDismissRequest = { onDismiss },
            DialogProperties(
                dismissOnBackPress = isDismissOnBack,
                dismissOnClickOutside = isDismissOnClickOutside
            )
        ) {
            Column {
                Image(painter = painterResource(id = imageId!!), contentDescription = "popup Image")

                Text(
                    text = dialogText,
                    style = TextStyle(
                        color = Color.White, fontSize = TextUnit(value = 14f, type = TextUnitType.Sp),
                        fontWeight = FontWeight.Bold
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.padding(10.dp)
                ) {
                    OutlinedButton(
                        onClick = { positiveButtonClicked },
                        modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color.Green,
                            contentColor = Color.White,
                            disabledContentColor = Color.LightGray
                        ),

                        ) {
                        Text(text = "OK")
                    }
                    OutlinedButton(
                        onClick = { negativeButtonClicked },
                        modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color.Red,
                            contentColor = Color.White,
                            disabledContentColor = Color.LightGray
                        ),

                        ) {
                        Text(text = "Cancel")
                    }
                }
            }
        }
    }
}

@Composable

fun BottomTabBar(){
    BottomNavigation(
        modifier=Modifier.fillMaxWidth().padding(12.dp)
            .clip(RoundedCornerShape(25.dp)),
        backgroundColor = Color(227,227,227),
        elevation = 5.dp,

    ) {
        BottomNavigationItem(
            icon = { Icons.Filled.Home },
            label = { Text(text = "Home")},
            alwaysShowLabel = false, // This hides the title for the unselected items
            onClick = {},
            selected = true,
            selectedContentColor = Color(0,165,155)

        )
        BottomNavigationItem(
            icon = { Icons.Filled.Home },
            label = { Text(text = "Home")},
            alwaysShowLabel = false, // This hides the title for the unselected items
            onClick = {},
            selected = true,
            selectedContentColor = Color(0,165,155)

        )
        BottomNavigationItem(
            icon = { Icons.Filled.Home },
            label = { Text(text = "Home")},
            alwaysShowLabel = false, // This hides the title for the unselected items
            onClick = {},
            selected = true,
            selectedContentColor = Color(0,165,155)

        )
        BottomNavigationItem(
            icon = { Icons.Filled.Home },
            label = { Text(text = "Home")},
            alwaysShowLabel = false, // This hides the title for the unselected items
            onClick = {},
            selected = true,
            selectedContentColor = Color(0,165,155)

        )
    }
}
