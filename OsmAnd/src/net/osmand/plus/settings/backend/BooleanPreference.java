package net.osmand.plus.settings.backend;

public class BooleanPreference extends CommonPreference<Boolean> {

	BooleanPreference(OsmandSettings settings, String id, boolean defaultValue) {
		super(settings, id, defaultValue);
	}

	@Override
	protected Boolean getValue(Object prefs, Boolean defaultValue) {
		return getSettingsAPI().getBoolean(prefs, getId(), defaultValue);
	}

	@Override
	protected boolean setValue(Object prefs, Boolean val) {
		return getSettingsAPI().edit(prefs).putBoolean(getId(), val).commit();
	}

	@Override
	public Boolean parseString(String s) {
		return Boolean.parseBoolean(s);
	}
}