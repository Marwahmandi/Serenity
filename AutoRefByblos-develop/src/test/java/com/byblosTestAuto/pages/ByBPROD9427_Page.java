package com.byblosTestAuto.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ByBPROD9427_Page {

	public String get_mission_et_client_depuis_BD() {

		String mission_et_client = null;

		String mission_BD = null;

		String client_BD = null;

		try {
			Class.forName("org.postgresql.Driver").newInstance();

			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:postgresql://talan-byblos-dev:5432/Byblos_Dev2", "byblos",
					"byblos");

			Statement st = connection.createStatement();

			String query = "SELECT distinct projet.intitule_, cltF.pc_raison_social\r\n"
					+ "FROM ctr_cout_tarif cct INNER JOIN ref_personnel p  USING (id_pers)\r\n"
					+ "LEFT JOIN pers_info_contrat USING (id_info_contrat)\r\n"
					+ "INNER JOIN ref_contrat ctr ON (cct.id_piece=ctr.id_piece) AND (ctr.ctr_type_piece IN ('CP','AP'))\r\n"
					+ "INNER JOIN ref_projet projet ON projet.id_projet=ctr.id_projet\r\n"
					+ "LEFT JOIN ref_prospect_client cltF ON cltF.id_fiche = ctr.id_fiche\r\n"
					+ "LEFT JOIN ref_contrat mirr ON mirr.id_contrat_source = ctr.id_piece\r\n"
					+ "WHERE p.id_pers = 24622 AND '2019-01-01' <= dt_fin_prest AND '2019-01-31' >= dt_deb_prest;";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				mission_et_client = rs.getString("intitule_") + "," + rs.getString("pc_raison_social");

				mission_BD = mission_et_client.split(",")[0];
				client_BD = mission_et_client.split(",")[1];

			}

		} catch (Exception ex) {

		}
		return mission_et_client;

	}

	public String get_Username_From_Value_In_Feature(String ValueInFeature) {

		String username = null;

		for (int i = 0; i < ValueInFeature.length(); i++) {
			username = username + i;
		}

		return username;
	}

}
