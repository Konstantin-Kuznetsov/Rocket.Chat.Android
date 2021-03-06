package chat.rocket.android.util

import chat.rocket.android.BuildConfig
import io.fabric.sdk.android.Fabric
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import android.content.Context
import chat.rocket.android.app.RocketChatApplication
import chat.rocket.android.infrastructure.installCrashlyticsWrapper

fun setupCrashlytics(context: Context) {
    val core = CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()
    Fabric.with(context, Crashlytics.Builder().core(core).build())

    installCrashlyticsWrapper(context as RocketChatApplication,
            context.getCurrentServerInteractor, context.settingsInteractor,
            context.accountRepository, context.localRepository)
}