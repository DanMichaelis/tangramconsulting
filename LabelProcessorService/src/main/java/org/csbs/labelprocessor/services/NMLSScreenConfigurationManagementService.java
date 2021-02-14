package org.csbs.labelprocessor.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.csbs.labelprocessor.domain.StringConfiguration;
import org.springframework.stereotype.Service;

/**
 * Business service for managing NMLS specific screen configurations. Invokes
 * data service to comply with the architecture, but is really just a
 * pass-through for getting and setting screen configuration data in various
 * formats. </br>
 * Screen configuration data contains screen keys and their corresponding
 * labels. The default values are loaded into the NMLS screen configuration
 * tables, and may be retrieved and saved as a .csv file for modification by an
 * administrator. Once modified (i.e. the group value is changed in the
 * listing), the file can be re-uploaded to allow the screen labels and messages
 * to be changed without code redeploy. </br>
 * Once the modified values have been uploaded, the front end application can
 * retrieve those values based on the display group that the individual is a
 * part of. Alternatively, the front end application can retrieve just the
 * default values if desired.
 * 
 * @author Dan
 *
 */
@Service
public class NMLSScreenConfigurationManagementService {

	//@Autowired
	//StringConfigurationDAO dao;

	/**
	 * Gets the list of all string configurations, including the DEFAULT string
	 * configurations
	 * 
	 * @return
	 */
	public List<StringConfiguration> getAllScreenConfigurations() {
		//return dao.findAll();
		return null;
	}

	/**
	 * Return the configurations for the specified display group. Intended to be
	 * used to customize strings for a target audience of users. This method returns
	 * the list of defaults augmented with the group values, so that if a group
	 * value is not specified for a key, the default value for that key will be
	 * returned
	 * 
	 * @param displayGroup the group of users for which the configurations should be
	 *                     displayed.
	 * @return the list of configurations appropriate for that group
	 */
	public List<StringConfiguration> getAllForDisplayGroup(String displayGroup) {
		// Retrieve both the default configs, and the configs for the specified group
		//List<StringConfiguration> displayGroupConfigs = dao.findByDisplayGroup(displayGroup);
		List<StringConfiguration> defaultConfigs = getDefaultConfiguration();

		// Create a HashMap of the default configs, so that we can replace the values
		// with the group configs if they exist.
		HashMap<String, StringConfiguration> configHash = new HashMap<String, StringConfiguration>();
		for (StringConfiguration sc : defaultConfigs) {
			configHash.put(sc.getKey(), sc);
		}

		// If there are any values in the display group, update the hashmap with the
		// display group values. If not, this won't do anything.
		//for (StringConfiguration sc : displayGroupConfigs) {
		//	configHash.put(sc.getKey(), sc);
		//}

		return new ArrayList<StringConfiguration>(configHash.values());
	}

	/**
	 * Returns default string configurations for the application
	 * 
	 * @return
	 */
	public List<StringConfiguration> getDefaultConfiguration() {
		//return dao.findByDisplayGroup("DEFAULT");
		return null;
	}

	/**
	 * Saves the passed list of configurations, excluding any configurations labeled
	 * with "Default". The default configurations can only be updated through an
	 * application installation, and not through user action.
	 * 
	 * @param configs
	 */
	public void saveConfigurations(List<StringConfiguration> configs) {
		// Remove any attempt to save to the DEFAULT group; that group must be loaded
		// through application installation
		for (StringConfiguration sc : configs) {
			if (sc.getGroup().equalsIgnoreCase("Default")) {
				configs.remove(sc);
			}
		}
		//dao.saveAll(configs);
	}

	public void removeDisplayGroup(String displayGroup) {
		//dao.deleteByDisplayGroup(displayGroup);
	}

}
