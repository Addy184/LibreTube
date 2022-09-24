package com.github.libretube.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.libretube.databinding.LegacySubscriptionChannelBinding
import com.github.libretube.extensions.toID
import com.github.libretube.ui.viewholders.LegacySubscriptionViewHolder
import com.github.libretube.util.ImageHelper
import com.github.libretube.util.NavigationHelper

class LegacySubscriptionAdapter(
    private val subscriptions: List<com.github.libretube.api.obj.Subscription>
) : RecyclerView.Adapter<LegacySubscriptionViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LegacySubscriptionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LegacySubscriptionChannelBinding.inflate(layoutInflater, parent, false)
        return LegacySubscriptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LegacySubscriptionViewHolder, position: Int) {
        val subscription = subscriptions[position]
        holder.binding.apply {
            channelName.text = subscription.name
            ImageHelper.loadImage(
                subscription.avatar,
                channelAvatar
            )
            root.setOnClickListener {
                NavigationHelper.navigateChannel(
                    root.context,
                    subscription.url!!.toID()
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return subscriptions.size
    }
}