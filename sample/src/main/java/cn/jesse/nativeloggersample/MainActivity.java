package cn.jesse.nativeloggersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.jesse.nativelogger.NLogger;
import cn.jesse.nativelogger.logger.LoggerLevel;
import cn.jesse.nativelogger.logger.base.IFileLogger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (TextView) findViewById(R.id.tv_test);
        test.setOnClickListener(this);


        NLogger.d("debug");
        NLogger.i("MainActivity", "type1");
        NLogger.w("MainActivity", "%s", "type2");
        NLogger.d("MainActivity", "%s%d%s", "type", 3, " finish");
        NLogger.json(LoggerLevel.INFO, "{\"code\":0,\"message\":\"\",\"data\":[{\"exchange_id\":\"AMEX\",\"code_id\":\"MFLA\",\"profit30d\":\"59.10\",\"codename\":\"IPATH LONG ENHANCED MSCI EAFE INDEX ETN\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"TONS\",\"profit30d\":\"47.25\",\"codename\":\"WisdomTree Coal Fund\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"SMLL\",\"profit30d\":\"43.62\",\"codename\":\"Direxion Daily Small Cap Bull 2X Shares\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"ROLA\",\"profit30d\":\"38.15\",\"codename\":\"IPATH LONG EXTENDED RUSSELL 1000\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"DUST\",\"profit30d\":\"31.79\",\"codename\":\"\\u9ec4\\u91d1\\u77ff\\u4e1a\\u4e09\\u500d\\u505a\\u7a7aETF-Direxion\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"LLSC\",\"profit30d\":\"29.38\",\"codename\":\"Direxion Daily Small Cap Bull 1.25X ETF\"}]}");
        NLogger.json(LoggerLevel.INFO, "[{\"exchange_id\":\"AMEX\",\"code_id\":\"MFLA\",\"profit30d\":\"59.10\",\"codename\":\"IPATH LONG ENHANCED MSCI EAFE INDEX ETN\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"TONS\",\"profit30d\":\"47.25\",\"codename\":\"WisdomTree Coal Fund\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"SMLL\",\"profit30d\":\"43.62\",\"codename\":\"Direxion Daily Small Cap Bull 2X Shares\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"ROLA\",\"profit30d\":\"38.15\",\"codename\":\"IPATH LONG EXTENDED RUSSELL 1000\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"DUST\",\"profit30d\":\"31.79\",\"codename\":\"\\u9ec4\\u91d1\\u77ff\\u4e1a\\u4e09\\u500d\\u505a\\u7a7aETF-Direxion\"},{\"exchange_id\":\"AMEX\",\"code_id\":\"LLSC\",\"profit30d\":\"29.38\",\"codename\":\"Direxion Daily Small Cap Bull 1.25X ETF\"}]");
    }

    @Override
    public void onClick(View v) {
        NLogger.zipLogs(new IFileLogger.OnZipListener() {
            @Override
            public void onZip(boolean succeed, String target) {
                if (succeed)
                    NLogger.i("zip", "succeed : " + target);
            }
        });
    }
}
