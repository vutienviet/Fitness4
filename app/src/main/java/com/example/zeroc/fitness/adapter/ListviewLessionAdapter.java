package com.example.zeroc.fitness.adapter;

public class ListviewLessionAdapter  {
//    private List<Item> listItem;
//    private LayoutInflater mLayoutInflater;
//    private Activity context;
//    int resource;
//
//
////    public ListviewLessionAdapter(Context mcontex, ArrayList<Item> listItem) {
////        this.context = mcontex;
////        this.listItem = listItem;
////        mLayoutInflater = LayoutInflater.from(mcontex);
////    }
//
//
////    public ListviewLessionAdapter(Context context, int resource, Item[] objects, List<Item> listItem, Activity context1, int resource1) {
////        super( context, resource, objects );
////        this.listItem = listItem;
////        this.context = context1;
////        this.resource = resource1;
////    }
//
//    public ListviewLessionAdapter(Activity context1, int resource1, ArrayList<Item> objects) {
//        super( context1, resource1, objects );
//        listItem = objects;
//        this.context = context1;
//        this.resource = resource1;
//    }
//
//    @Override
//    public int getCount() {
//        return listItem.size();
//    }
//
//    @Override
//    public Item getItem(int position) {
//        return listItem.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        mLayoutInflater = context.getLayoutInflater();
//        if (convertView == null){
//            convertView = mLayoutInflater.inflate( R.layout.item_lesson_button_1 , null);
//            holder = new ViewHolder();
//            holder.imgLession = convertView.findViewById(R.id.imgGiftLessonAction);
//            holder.tvnameLession = convertView.findViewById(R.id.tv_LessionName);
//            holder.tvDurations = convertView.findViewById(R.id.tv_durations);
//
//
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        Item item = this.listItem.get(position);
//        int imageld = this.getMipmapResIdByName(item.getImageLession());
//
////        holder.tvnameLession.setText( listItem.get( position ) .getNameLession()  );
////        holder.tvDurations.setText("durations : "+ listItem.get( position ).getDurations() );
////        Glide.with( context ).load( listItem.get( position ).getImageLession()).into( holder.imgLession );  //load tu database
//
//        holder.imgLession.setImageResource(imageld);
//        holder.tvnameLession.setText(item.getNameLession());
//        holder.tvDurations.setText("durations : " + item.getDurations());
//
//        return convertView;
//    }
//
//
//
//    public int getMipmapResIdByName(String resName){
//        String pkgName = context.getPackageName();
//
//        int resID = context.getResources().getIdentifier(resName , "mipmap" , pkgName);
//        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
//        return resID;
//    }
//
//    public void adddElement(Item element){
//        listItem.add( element );
//    }
//
//    static class ViewHolder{
//        ImageView imgLession;
//        TextView tvnameLession;
//        TextView tvDurations;
//    }
    }

