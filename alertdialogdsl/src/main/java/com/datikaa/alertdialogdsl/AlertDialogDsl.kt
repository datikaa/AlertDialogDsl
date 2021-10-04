package com.datikaa.alertdialogdsl

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ListAdapter
import androidx.annotation.*
import androidx.fragment.app.Fragment

@DslMarker
annotation class AlertDialogMarker

@AlertDialogMarker
class AlertDialogDsl(context: Context) {

    private val builder = AlertDialog.Builder(context)
    val context: Context = builder.context

    @AlertDialogMarker
    fun title(title: String) {
        builder.setTitle(title)
    }

    @AlertDialogMarker
    fun title(@StringRes titleId: Int) {
        builder.setTitle(titleId)
    }

    @AlertDialogMarker
    fun customTitle(customTitleView: View?) {
        builder.setCustomTitle(customTitleView)
    }

    @AlertDialogMarker
    fun message(message: String) {
        builder.setMessage(message)
    }

    @AlertDialogMarker
    fun message(@StringRes messageId: Int) {
        builder.setMessage(messageId)
    }

    @AlertDialogMarker
    fun icon(@DrawableRes iconId: Int) {
        builder.setIcon(iconId)
    }

    @AlertDialogMarker
    fun icon(@Nullable icon: Drawable?) {
        builder.setIcon(icon)
    }

    @AlertDialogMarker
    fun iconAttribute(@AttrRes attrId: Int) {
        builder.setIconAttribute(attrId)
    }

    @AlertDialogMarker
    fun positiveButton(
        text: String,
        click: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setPositiveButton(text, click)
    }

    @AlertDialogMarker
    fun positiveButton(
        @StringRes textId: Int,
        click: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setPositiveButton(textId, click)
    }

    @AlertDialogMarker
    fun positiveButtonIcon(icon: Drawable) {
        builder.setPositiveButtonIcon(icon)
    }

    @AlertDialogMarker
    fun negativeButton(
        text: String,
        click: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setNegativeButton(text, click)
    }

    @AlertDialogMarker
    fun negativeButton(
        @StringRes textId: Int,
        click: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setNegativeButton(textId, click)
    }

    @AlertDialogMarker
    fun negativeButtonIcon(icon: Drawable) {
        builder.setNegativeButtonIcon(icon)
    }

    @AlertDialogMarker
    fun neutralButton(text: String, click: (dialogInterface: DialogInterface, which: Int) -> Unit) {
        builder.setNeutralButton(text, click)
    }

    @AlertDialogMarker
    fun neutralButton(
        @StringRes textId: Int,
        click: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setNeutralButton(textId, click)
    }

    @AlertDialogMarker
    fun neutralButtonIcon(icon: Drawable) {
        builder.setNeutralButtonIcon(icon)
    }

    @AlertDialogMarker
    fun cancelable(cancelable: Boolean) {
        builder.setCancelable(cancelable)
    }

    @AlertDialogMarker
    fun onCancel(onCancel: (dialogInterface: DialogInterface) -> Unit) {
        builder.setOnCancelListener(onCancel)
    }

    @AlertDialogMarker
    fun onDismiss(onDismiss: (dialogInterface: DialogInterface) -> Unit) {
        builder.setOnCancelListener(onDismiss)
    }

    @AlertDialogMarker
    fun onKey(onKey: (dialogInterface: DialogInterface, keyCode: Int, keyEvent: KeyEvent) -> Boolean) {
        builder.setOnKeyListener(onKey)
    }

    @AlertDialogMarker
    fun items(
        @ArrayRes itemsId: Int,
        onItemClick: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setItems(itemsId, onItemClick)
    }

    @AlertDialogMarker
    fun items(
        items: Array<CharSequence>,
        onItemClick: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setItems(items, onItemClick)
    }

    @AlertDialogMarker
    fun adapter(
        adapter: ListAdapter,
        onItemClick: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setAdapter(adapter, onItemClick)
    }

    @AlertDialogMarker
    fun cursor(
        cursor: Cursor,
        onItemClick: (dialogInterface: DialogInterface, which: Int) -> Unit,
        labelColumn: String
    ) {
        builder.setCursor(cursor, onItemClick, labelColumn)
    }

    @AlertDialogMarker
    fun multiChoiceItems(
        @ArrayRes itemsId: Int,
        checkedItems: BooleanArray,
        onItemClick: (dialogInterface: DialogInterface, which: Int, isChecked: Boolean) -> Unit
    ) {
        builder.setMultiChoiceItems(itemsId, checkedItems, onItemClick)
    }

    @AlertDialogMarker
    fun multiChoiceItems(
        items: Array<CharSequence>,
        checkedItems: BooleanArray,
        onItemClick: (dialogInterface: DialogInterface, which: Int, isChecked: Boolean) -> Unit
    ) {
        builder.setMultiChoiceItems(items, checkedItems, onItemClick)
    }

    @AlertDialogMarker
    fun multiChoiceItems(
        cursor: Cursor,
        isCheckedColumn: String,
        labelColumn: String,
        onItemClick: (dialogInterface: DialogInterface, which: Int, isChecked: Boolean) -> Unit
    ) {
        builder.setMultiChoiceItems(cursor, isCheckedColumn, labelColumn, onItemClick)
    }

    @AlertDialogMarker
    fun multiChoiceItems(init: ChoiceItemBuilder.() -> Unit) {
        val itemsBuilder = ChoiceItemBuilder()
        itemsBuilder.init()
        val items = itemsBuilder.list.map { it.first }.toTypedArray()
        val checkedItem = itemsBuilder.list.map { it.second }.toBooleanArray()
        builder.setMultiChoiceItems(items, checkedItem, itemsBuilder.clickListener)
    }

    @AlertDialogMarker
    fun singleChoiceItems(
        @ArrayRes itemsId: Int,
        checkedItem: Int,
        onItemClick: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setSingleChoiceItems(itemsId, checkedItem, onItemClick)
    }

    @AlertDialogMarker
    fun singleChoiceItems(
        items: Array<CharSequence>,
        checkedItem: Int,
        onItemClick: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setSingleChoiceItems(items, checkedItem, onItemClick)
    }

    @AlertDialogMarker
    fun singleChoiceItems(
        cursor: Cursor,
        checkedItem: Int,
        labelColumn: String,
        onItemClick: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setSingleChoiceItems(cursor, checkedItem, labelColumn, onItemClick)
    }

    @AlertDialogMarker
    fun singleChoiceItems(
        adapter: ListAdapter,
        checkedItem: Int,
        onItemClick: (dialogInterface: DialogInterface, which: Int) -> Unit
    ) {
        builder.setSingleChoiceItems(adapter, checkedItem, onItemClick)
    }

    @AlertDialogMarker
    fun singleChoiceItems(init: ChoiceItemBuilder.() -> Unit) {
        val itemsBuilder = ChoiceItemBuilder()
        itemsBuilder.init()
        val items = itemsBuilder.list.map { it.first }.toTypedArray()
        val checkedItem = itemsBuilder.list.map { it.second }.toBooleanArray()
        builder.setMultiChoiceItems(items, checkedItem, itemsBuilder.clickListener)
    }

    @AlertDialogMarker
    fun onItemSelected(
        onItemSelected: (parent: AdapterView<*>?, view: View?, position: Int, id: Long) -> Unit,
        onNothingSelected: (parent: AdapterView<*>?) -> Unit,
    ) {
        builder.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                onItemSelected(parent, view, position, id)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                onNothingSelected(parent)
            }
        })
    }

    @AlertDialogMarker
    fun view(@LayoutRes layoutResId: Int) {
        builder.setView(layoutResId)
    }

    @AlertDialogMarker
    fun view(view: View) {
        builder.setView(view)
    }

    @AlertDialogMarker
    fun create() = builder.create()

    @AlertDialogMarker
    fun show() {
        builder.show()
    }

    @AlertDialogMarker
    class ChoiceItemBuilder {
        val list = arrayListOf<Pair<CharSequence, Boolean>>()
        var clickListener: ((dialogInterface: DialogInterface, which: Int, isChecked: Boolean) -> Unit)? =
            null

        @AlertDialogMarker
        fun item(text: String, isChecked: Boolean) {
            list.add(Pair(text, isChecked))
        }

        @AlertDialogMarker
        fun onItemClick(onItemClick: (dialogInterface: DialogInterface, which: Int, isChecked: Boolean) -> Unit) {
            clickListener = onItemClick
        }
    }
}

@AlertDialogMarker
fun alertDialog(context: Context, init: AlertDialogDsl.() -> Unit) {
    val builder = AlertDialogDsl(context)
    builder.init()
}

@AlertDialogMarker
fun Fragment.alertDialog(init: AlertDialogDsl.() -> Unit) {
    alertDialog(requireContext(), init)
}

@AlertDialogMarker
fun Activity.alertDialog(init: AlertDialogDsl.() -> Unit) {
    alertDialog(this, init)
}
