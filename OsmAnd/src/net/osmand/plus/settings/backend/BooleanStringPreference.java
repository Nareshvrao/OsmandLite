package net.osmand.plus.settings.backend;

public class BooleanStringPreference extends BooleanPreference {

	public BooleanStringPreference(OsmandSettings osmandSettings, String id, boolean defaultValue) {
		super(osmandSettings, id, defaultValue);
	}

	@Override
	protected Boolean getValue(Object prefs, Boolean defaultValue) {
		Boolean value;
		try {
			value = parseString(getSettingsAPI().getString(prefs, getId(), defaultValue.toString()));
		} catch (ClassCastException e) {
			value = getSettingsAPI().getBoolean(prefs, getId(), defaultValue);
			setValue(prefs, value);
		}
		return value;
	}

	@Override
	protected boolean setValue(Object prefs, Boolean val) {
		return getSettingsAPI().edit(prefs).putString(getId(), val != null ? val.toString() : null).commit();
	}
}