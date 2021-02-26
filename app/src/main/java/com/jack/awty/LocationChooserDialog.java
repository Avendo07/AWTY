package com.jack.awty;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.jack.awty.viewmodels.MainActivityViewModel;

public class LocationChooserDialog extends DialogFragment {
	//TODO:Update stations from official data using a Room database
	
	public LocationChooserDialog(){}
	
	private AutoCompleteTextView location_text_view;
	private MainActivityViewModel viewModel;
	
	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
		//Creates a Dialog
		//Hello Dialog
		//TODO: Implement shared viewnmodel to share the chosen thing to alarmFragment
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = requireActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.dialog_location_chooser, null);
		builder.setView(dialogView)
				.setPositiveButton(R.string.common_signin_button_text, (dialog, which) -> {
					//TODO:Alarm creation affirmative
				})
				.setNegativeButton(R.string.app_name, (dialog, which) -> LocationChooserDialog.this.getDialog().cancel());
		
		//Sets the autocomplete textView adapter
		location_text_view = dialogView.findViewById(R.id.edit_text_location_choose);
		ArrayAdapter adapter = new ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1);
		location_text_view.setAdapter(adapter);
		viewModel = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
		viewModel.getmStations().observe(requireActivity(), strings -> {
			adapter.clear();
			adapter.addAll(strings);
			adapter.notifyDataSetChanged();
		});
		return builder.create();
	}
	
	
	@Override
	public void onCancel(@NonNull DialogInterface dialog) {
		super.onCancel(dialog);
		Toast.makeText(getContext(), "Not Saved!", Toast.LENGTH_LONG).show();
	}
}
