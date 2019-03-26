package com.test.kotlinmvvm.view.avatars

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.kotlinmvvm.R
import com.test.kotlinmvvm.model.Avator
import com.test.kotlinmvvm.view.avatars.AvatarAdapter.AvatarListener
import kotlinx.android.synthetic.main.layout_avatar_bottom_sheet.*

class AvatarBottomSheetDailogFragment : BottomSheetDialogFragment(), AvatarListener{


    private lateinit var callback: AvatarListener


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_avatar_bottom_sheet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        avatarRecyclerView.layoutManager=GridLayoutManager(context,3)
        avatarRecyclerView.adapter=AvatarAdapter(AvatarStore.AVATARS,this)



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        try {
            callback = activity as AvatarAdapter.AvatarListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement AvatarAdapter.AvatarListener")
        }
    }

    override fun avatarClicked(avatar: Avator) {
        callback.avatarClicked(avatar)
    }

    companion object {
        fun newInstance(): AvatarBottomSheetDailogFragment {
            return AvatarBottomSheetDailogFragment()
        }
    }

}