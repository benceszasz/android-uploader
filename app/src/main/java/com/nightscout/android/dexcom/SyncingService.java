package com.nightscout.android.dexcom;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous Dexcom downloads and cloud upload
 * requests in a service on a separate handler thread.
 * <p>
 * helper methods.
 */
public class SyncingService extends IntentService {

    private static final String ACTION_SYNC = "com.nightscout.android.dexcom.action.SYNC";

    private static final String EXTRA_PARAM1 = "com.nightscout.android.dexcom.extra.2DAY";
    private static final String EXTRA_PARAM2 = "com.nightscout.android.dexcom.extra.SINGLE";

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startActionSync(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SyncingService.class);
        intent.setAction(ACTION_SYNC);
        intent.putExtra(EXTRA_PARAM2, param1);
        context.startService(intent);
    }

    public SyncingService() {
        super("SyncingService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SYNC.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                handleActionSync(param1);
            }
        }
    }

    /**
     * Handle action Sync in the provided background thread with the provided
     * parameters.
     */
    private void handleActionSync(String param1) {
        // TODO: Handle action Sync
        throw new UnsupportedOperationException("Not yet implemented");
    }

}