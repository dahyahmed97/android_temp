package com.example.consumeplusupgradedsample.ui.screens.loginScreen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.consumeplusupgradedsample.R
import com.example.consumeplusupgradedsample.utils.*


@ExperimentalUnitApi
@Composable
fun  LoginPageView(context: Context, navHostController: NavHostController, viewModel: SignInScreenViewmodel){


    Scaffold{
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .fillMaxSize()
                .background(color = Color.White),
        ) {
            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        reverseScrolling = true,
                        enabled = true,
                        state = rememberScrollState(0)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "logo",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .background(color = Color.White)
                        .padding(
                            top = 53.dp
                        ),
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_login_artwork),
                    contentDescription = "logo",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .background(color = Color.White)
                        .padding(
                            top = 53.dp
                        ),
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 43.dp, top = 40.dp, end = 43.dp)
                ) {
                    Text(
                        text = "Hello,",
                        style = TextStyle(
                            color = Color(green = 32, red = 2, blue = 105),
                            fontSize = TextUnit(28f, TextUnitType.Sp),
                            fontWeight = FontWeight.Bold
                        ),

                        )
                    Text(
                        text = "Login to Continue",
                        style = TextStyle(
                            color = Color(green = 32, red = 2, blue = 105),
                            fontSize = TextUnit(28f, TextUnitType.Sp),
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 30.dp)

                    )
                    CustomTextFiled(
                        hintLabel = "phone number",
                        textVal = viewModel.phoneNumberText.value,
                        onValChange = { viewModel.formValidation(it, null) },
                        leadIcon = {
                            Icon(
                                imageVector = Icons.Filled.Phone,
                                contentDescription = ""
                            )
                        },
                        trailIcon = {},
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done
                        ),
                        customVisualTransformation = VisualTransformation.None
                    )
                    CustomTextFiled(
                        hintLabel = "password",
                        textVal = viewModel.passwordText.value,
                        onValChange = { viewModel.formValidation(null, it) },
                        leadIcon = {
                            Icon(
                                imageVector = Icons.Filled.Lock,
                                contentDescription = ""
                            )
                        },
                        trailIcon = { ToggleShowPasswordButton { viewModel.showHidePassword() } },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        customVisualTransformation = if (viewModel.isPasswordShown.value) VisualTransformation.None else PasswordVisualTransformation(),
                    )

                }

                Column(
                    modifier = Modifier.padding(bottom = 10.dp, start = 43.dp, end = 43.dp)
                ) {
                    CustomButton(isEnabled = viewModel.isNextButtonEnabled.value,
                        buttonLabel = "Sign In",
                        onClicked = {
                            viewModel.userLogin(context, navHostController)

                        }
                    )


                }


            }

          ProgressIndicator(showDialog = viewModel.loading.value)

            CustomAlertDialog(
                onDismiss = { viewModel.isAlertDialogVisible.value = false },
                isDismissOnBack = true,
                isDismissOnClickOutside =false ,
                imageId = null ,
                positiveButtonClicked = { viewModel.isAlertDialogVisible.value = false },
                negativeButtonClicked = {viewModel.isAlertDialogVisible.value = false  },
                dialogText = viewModel.alertDialogMessage.value ,
                isDialogVisible = viewModel.isAlertDialogVisible.value
            )


        }
    }
}