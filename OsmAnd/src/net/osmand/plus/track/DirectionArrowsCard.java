package net.osmand.plus.track;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import net.osmand.plus.R;
import net.osmand.plus.activities.MapActivity;
import net.osmand.plus.helpers.AndroidUiHelper;
import net.osmand.plus.routepreparationmenu.cards.BaseCard;

public class DirectionArrowsCard extends BaseCard {

	private TrackDrawInfo trackDrawInfo;

	public DirectionArrowsCard(@NonNull MapActivity mapActivity, @NonNull TrackDrawInfo trackDrawInfo) {
		super(mapActivity);
		this.trackDrawInfo = trackDrawInfo;
	}

	@Override
	public int getCardLayoutId() {
		return R.layout.bottom_sheet_item_with_switch;
	}

	@Override
	protected void updateContent() {
		AndroidUiHelper.updateVisibility(view.findViewById(R.id.icon), false);

		TextView titleView = view.findViewById(R.id.title);
		titleView.setText(R.string.gpx_direction_arrows);

		final CompoundButton compoundButton = view.findViewById(R.id.compound_button);
		compoundButton.setChecked(trackDrawInfo.isShowArrows());

		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean checked = !compoundButton.isChecked();
				compoundButton.setChecked(checked);
				trackDrawInfo.setShowArrows(checked);
				mapActivity.refreshMap();

				CardListener listener = getListener();
				if (listener != null) {
					listener.onCardPressed(DirectionArrowsCard.this);
				}
			}
		});
	}
}